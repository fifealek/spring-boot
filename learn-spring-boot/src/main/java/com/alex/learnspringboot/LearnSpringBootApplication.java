package com.alex.learnspringboot;

import static java.util.stream.Collectors.toList;

import org.reactivestreams.Subscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;


@SpringBootApplication
public class LearnSpringBootApplication {

    private static String password = "fife1980";


    static void fluxLearn() {
        Flux.just((Supplier<String>) () -> "a", (Supplier<String>) () -> "b", (Supplier<String>) () -> "c")
                .subscribe(suplier -> System.out.println(suplier.get()));
    }

    static void fluxLearn1() {
//        Flux.just("alpha", "bravo", "charlie").map(String::toUpperCase).
//                flatMap(s -> Flux.fromArray(s.split("")))
//                .groupBy(String::toString).
//                sort((o1, o2) -> o1.key().compareTo(o2.key())).
//               // flatMap(group -> Mono.just(group.key()).and(group.count()) ).//.map(c->c.)
//                subscribe(System.out::println);
//
//        Flux.just("alpha", "bravo", "charlie")
//                .map(String::toUpperCase)
//                .flatMap(s -> Flux.fromArray(s.split("")))
//                .groupBy(String::toString)
//                .sort((o1, o2) -> o1.key().compareTo(o2.key()))
//                .flatMap(group -> Mono.just(group.key()).and(group.count()))
//               // .map(keyAndCount ->
//               //         keyAndCount.getT1() + " => " + keyAndCount.getT2())
//                .subscribe(System.out::println);
//        Flux.just("red", "white", "blue")
//                .log()
//                .map(String::toUpperCase)
//                .subscribe(System.out::println);

        Mono<List<String>> flist= Flux.just("red", "white", "blue")
                .log()
                .map(String::toUpperCase).collect(toList());
        List<String> list = flist.block();
        System.out.println(list);

        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe(i -> System.out.println(i));

        Flux<Integer> ints1 = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) {
                        return i;
                    }
                    throw new RuntimeException("Got to 4");
                });
        ints1.subscribe(
                i -> System.out.println(i), error -> System.err.println("Error: " + error)
        );

        Flux<Integer> ints2 = Flux.range(1, 4);
        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> {System.out.println("Done");
                });
    }


    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
        // fluxLearn();
//        fluxLearn1();
    }

}
