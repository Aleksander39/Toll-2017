package jdev.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.BlockingDeque;

@Service
public class SendService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    StorageService storageService;


    //@Scheduled(cron = "${cron.prop}")
    public PointDTO[] send(PointDTO pointDTO) {
        BlockingDeque<PointDTO> queue = storageService.getAll();
        PointDTO[] points = new PointDTO[queue.size()];

        int i = 0;
        for(PointDTO point : queue) {
            points[i++] = point;
            storageService.getAll().remove(point);
        }

       return restTemplate.postForObject("http//localhost:8080/point",pointDTO , PointDTO[].class);

    }




}
