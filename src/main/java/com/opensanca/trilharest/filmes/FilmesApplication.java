package com.opensanca.trilharest.filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by PEDRO on 07/10/2017.
 */
@EnableAutoConfiguration
@ComponentScan
public class FilmesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmesApplication.class, args);
    }
}
