package com.test.exam;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * zip 예제
 */
@Slf4j
public class Example14_36 {
    public static void main(String[] args) throws InterruptedException {
        Flux
            .zip(
                    Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300L)),
                    Flux.just(4, 5, 6).delayElements(Duration.ofMillis(500L)),
                    (n1, n2) -> n1 * n2
            )
            .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(2500L);
    }
}