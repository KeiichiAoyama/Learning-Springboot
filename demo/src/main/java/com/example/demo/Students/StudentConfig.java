package com.example.demo.Students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Students mariam = new Students("Mariam", LocalDate.of(2000, Month.JANUARY, 5), "mariam.jamal@gmail.com");
            Students alex = new Students("Alex", LocalDate.of(2004, Month.JANUARY, 5), "alex@gmail.com");

            repository.saveAll(
                List.of(mariam, alex)
            );
        };
    }
}
