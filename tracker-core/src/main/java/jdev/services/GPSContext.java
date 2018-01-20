package jdev.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class GPSContext {
    @Bean
    GPSService gpsService(){
        return new GPSService();
    }
    @Bean
    SendService sendService(){
        return new SendService();
    }
    @Bean
    StorageService storageService(){
        return new StorageService();
    }

}
