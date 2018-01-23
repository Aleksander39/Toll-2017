package jdev.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SendService {
    @Autowired
    StorageService storageService;
    @Autowired
    GPSService gpsService;

    private static final Logger log = LoggerFactory.getLogger(SendService.class);
    private long previous;

    @Scheduled(cron = "${cron.prop}")
    public void send() throws InterruptedException {
        long current = System.currentTimeMillis();
        log.info((current - previous)+ storageService.take());
        previous = current;
    }
    @PostConstruct
    @Scheduled(cron = "${cron.prop.gps}")
    private  void init() throws JsonProcessingException, InterruptedException {
        storageService.put(gpsService.getGPS());
    }
}
