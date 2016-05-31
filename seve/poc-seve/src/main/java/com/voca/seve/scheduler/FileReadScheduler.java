package com.voca.seve.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ajay.thakur on 31/05/2016.
 */
@Configuration
@ComponentScan(basePackages="com.voca.seve.scheduler")
@EnableScheduling
public class FileReadScheduler {

    @Scheduled(fixedRate=1000*30)
    public void doTask() throws IOException {
        System.out.println("Do Task...");

        try {

            List<File> filesInFolder = Files.walk(Paths.get("..\\incoming"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            for (File file : filesInFolder) {
                System.out.println(" File Name :" + file.getName());
                file.renameTo(new File("..\\outgoing\\" + file.getName()));

            }

        }catch(Exception e){
            System.out.println("Exception Exception Exception Exception Exception Exception ");
        }

    }

    public static void main(String[] args) throws IOException {
//        doTask();

    }

}
