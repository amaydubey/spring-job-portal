package com.baeldung.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author amayd
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "edu.cmpe275.jobboard.*")
public class JobBoardApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(JobBoardApplication.class, args);
    }

}
