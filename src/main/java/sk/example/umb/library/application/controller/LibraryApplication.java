package sk.example.umb.library.application.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(LibraryApplication.class, args);
    }

}
