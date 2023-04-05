package com.fan.learn.maven.release.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

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
}
