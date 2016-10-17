package com.zhoulei.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class Config {
    @Bean
    public ExecutorService getExecutorService(){

        return Executors.newFixedThreadPool(4 + 1, new ThreadFactory() {
            private AtomicInteger integer = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"threadID"+integer.getAndIncrement());
            }
        });
    }





}
