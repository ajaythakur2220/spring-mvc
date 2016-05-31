package com.voca.seve.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by ajay.thakur on 31/05/2016.
 */
@Configuration
@ComponentScan(basePackages="com.voca.seve.scheduler")
@EnableScheduling
public class FileReadScheduler {

    @Scheduled(fixedRate=1000*30)
    public void doTask() {
        System.out.println("Do Task...");
    }


}
