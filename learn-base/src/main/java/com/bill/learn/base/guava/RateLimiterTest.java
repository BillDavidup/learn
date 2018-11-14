package com.bill.learn.base.guava;

import com.bill.learn.base.common.MyCallable;
import com.bill.learn.base.common.MyThreadFactory;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;

import java.sql.Time;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * guava的RateLimiter单接口平滑限流
 * 令牌桶算法不能与另外一种常见算法漏桶算法相混淆。这两种算法的主要区别在于漏桶算法能够强行限制数据的传输速率，
 * 而令牌桶算法在能够限制数据的平均传输速率外，还允许某种程度的突发传输。在令牌桶算法中，只要令牌桶中存在令牌，
 * 那么就允许突发地传输数据直到达到用户配置的门限，因此它适合于具有突发特性的流量。
 * Created by bill on 2018/11/5.
 */
public class RateLimiterTest {

    public static void main(String[] args) {
        //自定义MyThreadFactory没有打印出自定义的线程名称，等待解决
        testRateLimiter();
        testRateLimiter2();
    }

    /**
     * SmoothBursty 有一个可以放 N 个时间窗口产生的令牌的桶，系统空闲的时候令牌就一直攒着，
     * 最好情况下可以扛 N 倍于限流值的高峰而不影响后续请求。RateLimite允许某次请求拿走超出剩余令牌数的令牌，
     * 但是下一次请求将为此付出代价，一直等到令牌亏空补上，并且桶中有足够本次请求使用的令牌为止。
     * 当某次请求不能得到所需要的令牌时，这时涉及到一个权衡，是让前一次请求干等到令牌够用才走掉呢，还是让它先走掉后面的请求等一等呢？Guava 的设计者选择的是后者，先把眼前的活干了，后面的事后面再说。
     */
    public static void testRateLimiter() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(
                Executors.newCachedThreadPool(new MyThreadFactory()));
        //SmoothBursty(令牌桶) 平滑突发限流
        RateLimiter rateLimiter = RateLimiter.create(5.0);
        for (int i = 0; i < 20; i++) {
            System.out.println(rateLimiter.acquire());
            final ListenableFuture<Integer> listenableFuture = executorService
                    .submit(new MyCallable("RateLimiter"));
        }
        executorService.shutdown();

    }

    public static void testRateLimiter2() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(
                Executors.newCachedThreadPool(new MyThreadFactory()));
        //SmoothWarmingUp（漏桶）平滑预热限流:保护系统瞬间扛不住突发流量，2000毫秒内从启动到慢慢加到平均速率
        //漏桶(Leaky Bucket)算法思路很简单,水(请求)先进入到漏桶里,漏桶以一定的速度出水(接口有响应速率),
        // 当水流入速度过大会直接溢出(访问频率超过接口响应速率),然后就拒绝请求,可以看出漏桶算法能强行限制数据的传输速率.
        RateLimiter rateLimiter = RateLimiter.create(5.0, 5000, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 20; i++) {
            System.out.println(rateLimiter.acquire());
            System.out.println(rateLimiter.getRate());
            final ListenableFuture<Integer> listenableFuture = executorService
                    .submit(new MyCallable("RateLimiter"));
            try {
                System.out.println(listenableFuture.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

}
