package jdev.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
@ComponentScan({"jdev.controllers","jdev.services"})
public class RestServer {

    public static void main(String...args) throws IOException {
        SpringApplication.run(RestServer.class,args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
