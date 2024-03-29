package br.com.sw2you.realmeet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ExecutorsConfinguration {


    @Bean
    public Executor  controllerExecutor(
            @Value("${realmeet.taskExecutor.pool.coreSize:10}")int corePoolSize,
            @Value("${realmeet.taskExecutor.pool.maxSize:20}") int maxPoolSize,
            @Value("${realmeet.taskExecutor.pool.queueCapacity:50}") int queryCapaxity,
            @Value("${realmeet.taskExecutor.pool.keepAliveSeconds:60}") int keepAliveSeconds){
        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveSeconds,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queryCapaxity,true));
    }

}
