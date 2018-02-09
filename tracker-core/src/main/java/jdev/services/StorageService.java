package jdev.services;


import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class StorageService {

    private BlockingDeque<PointDTO> queue = new LinkedBlockingDeque<>(100);

    PointDTO take() throws InterruptedException {
        return  queue.take();
    }

    void put(PointDTO pointDTO) throws InterruptedException {
        queue.put(pointDTO);
    }
    BlockingDeque<PointDTO> getAll() {
        return queue;
    }
}
