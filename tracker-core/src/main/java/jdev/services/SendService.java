package jdev.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    @Autowired
    StorageService storageService;

    private static final Logger log = LoggerFactory.getLogger(SendService.class);
    private long previous;

    @Scheduled(fixedRate = 2000)
    public void send() throws InterruptedException {
        long current = System.currentTimeMillis();
        log.info((current - previous)+ storageService.take());
        previous = current;
    }
}
