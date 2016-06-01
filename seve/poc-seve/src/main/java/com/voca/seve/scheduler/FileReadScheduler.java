package com.voca.seve.scheduler;

import com.voca.seve.tset.reception.MSG01PmtSubm;
import com.voca.seve.tset.reception.TsetReceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Created by ajay.thakur on 31/05/2016.
 */
@Configuration
@EnableScheduling
public class FileReadScheduler {

     static TsetReceptionHandler tsetReceptionHandler ;

    @Scheduled(fixedRate=1000*30)
    public static void doTask() throws IOException {
        System.out.println("Do Task...");

        try {

            List<File> filesInFolder = Files.walk(Paths.get("C:\\development\\IPS\\seve\\poc-seve\\src\\main\\resources\\I_101001_MSG01_1512180000001.xml"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            for (File file : filesInFolder) {
                tsetReceptionHandler = new TsetReceptionHandler();
                System.out.println(" File Name :" + file.getName());
                //do parsing
                tsetReceptionHandler.handleFileParsing(file);




//                file.renameTo(new File("..\\outgoing\\" + file.getName()));

            }

        }catch(Exception e){
            System.out.println("Exception Exception Exception Exception Exception Exception " );
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        doTask();

    }

}
