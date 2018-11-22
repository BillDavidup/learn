package com.bill.learn.base.algorithm.safehashmapimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * HashMap的get put clear的线程安全实现
 * HashMap用作缓存的时候如何保证线程安全
 * 读写锁的应用
 * Created by bill on 2018/11/21.
 */
public class SafeHashMap {
    static Map<String, Object> hashMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    /**
     * 获取一个key的value
     * @param key k
     * @return obj
     */
    public static final Object get(String key) {
        r.lock();
        try {
            return hashMap.get(key);
        } finally {
            r.unlock();
        }
    }

    /**
     * 设置键值对
     * @param key k
     * @param value v
     * @return 返回旧value
     */
    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return hashMap.put(key, value);
        } finally {
            w.unlock();
        }
    }

    /**
     * 清空所有内容
     */
    public static final void clear() {
        w.lock();
        try {
            hashMap.clear();
        } finally {
            w.unlock();
        }
    }
}
