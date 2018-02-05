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
import java.util.concurrent.BlockingDeque;

@Service
public class SendService {
    @Autowired
    StorageService storageService;

    @Autowired
    RestTemplate restTemplate;


    @Scheduled(cron = "${cron.prop}")
    public void send(){
        for(PointDTO pointDTO:storageService.getAll()) {
            restTemplate.postForObject("http://localhost:8080/point", pointDTO, PointDTO.class);
        }
    }


    @PostConstruct
    @Scheduled(cron = "${cron.prop.gps}")
    private  void init(PointDTO pointDTO) throws JsonProcessingException, InterruptedException {
        storageService.put(pointDTO);
    }
}
