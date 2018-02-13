package jdev.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.BlockingDeque;


@Service
public class SendService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    StorageService storageService;
    String url = "http://localhost:8080/points/";



    @Scheduled(cron = "${cron.prop}")
    public PointDTO[] send() {
        int i=0;
        BlockingDeque<PointDTO> queue = storageService.getAll();
        PointDTO[]pointDTOS = new PointDTO[queue.size()];

        for(PointDTO pointDTO:queue){
            pointDTOS[i++]=pointDTO;
            storageService.getAll().remove(pointDTO);

        }
      return   restTemplate.postForObject(url, pointDTOS,PointDTO[].class);

    }

}




