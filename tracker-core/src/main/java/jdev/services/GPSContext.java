package jdev.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
