package com.fan.learn.maven.release.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author jianbo
 * @Date 2023/4/5 14:24
 * @Version 1.0
 * @Description <br/>
 *
 */
@RestController
public class ReleaseController {

    @GetMapping("/mvn/plugin/release")
    public Mono<String> helloRelease(@RequestParam(required = false) String name) {
        return Mono.defer(() -> Mono.just("hello," + Optional.ofNullable(name).orElse("jianbo")));
    }

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
                sink.next(ThreadLocalRandom.current().nextInt(1000, 9999) + "\r\n");
            }
            sink.complete();
        });
    }
}
