package com.alex.learnspringboot.configuration;

import com.alex.learnspringboot.data.Chapter;
import com.alex.learnspringboot.repository.ChapterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {

    private ChapterRepository repository;
//    @Bean
//    CommandLineRunner init(ChapterRepository repository) {
//    //    return args -> {
////            Flux.just(
////                    new Chapter("Quick Start with Java"),
////                    new Chapter("Reactive Web with Spring Boot"),
////                    new Chapter("...and more!"))
////                    .flatMap(repository::save)
////                    .subscribe(System.out::println);
////        };
//    }

}
