package com.amos.reactutil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author chenjun
 * @date 2020/6/15 7:58
 */
public class ReactExample {

    public static void main(String[] args) {

        Mono<String> data = Mono.just("hello world");
        data.subscribe(System.out::println);

        Flux<Integer> range = Flux.range(1, 100);
        range.subscribe(System.out::println);

    }
}
