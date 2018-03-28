package jdev.services;


import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class StorageService  {

    @Autowired
    PointDTOService pointService;

    void put(PointDTO pointDTO) throws InterruptedException {
        pointService.create(pointDTO);

    }

    public List<PointDTO> getTail(long time){
        return pointService.findByTimeGreaterThan(time);
    }





}
