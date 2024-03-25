package org.example.stations;

import org.example.stations.entity.StationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StationsApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StationsApplication.class, args);
    }
}