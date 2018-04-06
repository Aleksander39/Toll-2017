package jdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import java.io.IOException;

@SpringBootApplication
@ComponentScan({"jdev.controllers","jdev.dao","jdev.repositories","jdev.services"})
@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class})
public class RestServer  {

    public static void main(String...args) throws IOException {
        SpringApplication.run(RestServer.class,args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
