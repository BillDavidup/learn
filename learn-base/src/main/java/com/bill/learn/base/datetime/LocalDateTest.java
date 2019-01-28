package com.bill.learn.base.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.minusDays(6));
        LocalDateTime beginTime = LocalDateTime.now().minusDays(6).withHour(0).withMinute(0).withSecond(0);
        long begin = beginTime.minusHours(-2*1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(begin);

        LocalDateTime beginTime2 = LocalDateTime.now().minusDays(6).withHour(0).withMinute(0).withSecond(0);
        long begin2 = beginTime.plusHours(2*0).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(begin2);
        System.out.println(TimeUnit.MINUTES.toSeconds(5));
    }
}
