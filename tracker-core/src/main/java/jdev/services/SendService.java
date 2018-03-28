package jdev.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.BlockingDeque;


@Service
public class SendService  {
    private static Logger log = LoggerFactory.getLogger(SendService.class);
    @Autowired
    RestTemplate restTemplate;

    private long time;

    @Autowired
    StorageService storageService;
    String url = "http://localhost:8080/points/";

    public SendService(@Autowired StorageService storageService,
                       @Autowired RestTemplate restTemplate) {
        this.storageService = storageService;
        this.restTemplate = restTemplate;
    }


    @Scheduled(cron = "${cron.prop}")
    public void send() throws JsonProcessingException {
        List<PointDTO> baseTail = storageService.getTail(time);
        for(int i = 0; i < baseTail.size(); i++){
            PointDTO record = baseTail.get(i);
            try{
                String requestJson = record.toJson();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<String> coord = new HttpEntity<String>(requestJson, headers);

                ResponseEntity<Boolean> answer = restTemplate.exchange(url, HttpMethod.POST, coord, Boolean.class);

                if (!answer.getBody()) {
                    log.info("Server Error");
                    return;
                }
                time = record.getTime();
                log.info(record.toJson());

            } catch (JsonProcessingException jpe) {
                jpe.printStackTrace();
            } catch (ResourceAccessException ex) {
                log.info("ResourceAccessException");
                return;
            }
        }

    }

}




