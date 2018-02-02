package jdev.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class SendService {
    @Autowired
    StorageService storageService;
    @Autowired
    GPSService gpsService;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(SendService.class);


    @Scheduled(cron = "${cron.prop}")
    public PointDTO send(PointDTO pointDTO){
        return  restTemplate.postForObject("http://localhost:8080/coords",pointDTO,PointDTO.class);
    }
    @PostConstruct
    @Scheduled(cron = "${cron.prop.gps}")
    private  void init() throws JsonProcessingException, InterruptedException {
        storageService.put(gpsService.getGPS());
    }
}
