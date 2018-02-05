package jdev.controllers;


import jdev.dto.PointDTO;
import jdev.services.RecFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TrackerController {
    @Autowired
    RecFileService recFileService;

    Logger logger = LoggerFactory.getLogger(TrackerController.class);
    private long previous;

    @RequestMapping(value = "point", method = RequestMethod.POST)
    @ResponseBody

     public PointDTO receive(@RequestBody PointDTO pointDTO) throws IOException {
        long current = System.currentTimeMillis();
        logger.info((current - previous) +
                        ",lat = " + pointDTO.getLat() +
                        ",lon = " + pointDTO.getLon()+
                        ",azimuth = "+pointDTO.getAzimuth()+
                        ",instaSpeed = "+pointDTO.getInstaSpeed()+
                        ", autoId = "+pointDTO.getAutoId()
                );
        recFileService.writeInFile((current - previous) + ",lat = " + pointDTO.getLat() +
                ",lon = " + pointDTO.getLon()+
                ",azimuth = "+pointDTO.getAzimuth()+
                ",instaSpeed = "+pointDTO.getInstaSpeed()+
                ", autoId = "+pointDTO.getAutoId());
        return pointDTO;
     }



}
