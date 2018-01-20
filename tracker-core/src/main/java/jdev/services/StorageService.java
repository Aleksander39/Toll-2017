package jdev.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class StorageService {
    private BlockingQueue<String> queue = new LinkedBlockingDeque<>(100);
    String take() throws InterruptedException {
        return  queue.take();
    }

    void put(String gpsPoint) throws InterruptedException {
        queue.put(gpsPoint);
    }
}
