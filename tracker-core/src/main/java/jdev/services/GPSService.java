package jdev.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class GPSService {

    @Autowired
    StorageService storageService;

    @Autowired
    TrackService trackService;

    @PostConstruct
    @Scheduled(cron = "${cron.prop.gps}")
    private  void init() throws JsonProcessingException, InterruptedException {
        storageService.put(trackService.getGPS());
    }

}
