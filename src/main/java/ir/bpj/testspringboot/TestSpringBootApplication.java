package ir.bpj.testspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class TestSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBootApplication.class, args);
        System.out.println("hello");
    }

}