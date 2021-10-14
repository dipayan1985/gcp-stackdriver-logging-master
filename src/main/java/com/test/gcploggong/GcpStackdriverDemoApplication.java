package com.test.gcploggong;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GcpStackdriverDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GcpStackdriverDemoApplication.class, args);
    }
}

@RestController
@Slf4j
class Foo {
    @Autowired
    MeterRegistry stackDriverMeterRegistry;

    @GetMapping("/test")
    public String bar() throws InterruptedException {
        stackDriverMeterRegistry.counter("gcp_dipayan").increment(10.0);
        log.info("Test logged");

        TimeUnit.MILLISECONDS.sleep(30);

        log.info("Check span");
        return "tested";
    }
}
