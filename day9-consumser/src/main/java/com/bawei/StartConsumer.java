package com.bawei;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class StartConsumer {

    public static void main(String[] args) {
        SpringApplication.run(StartConsumer.class);
    }

}
