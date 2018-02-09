package jdev.controllers;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;


@RestController
public class TrackerController {

    private final RestTemplate restTemplate;

    public TrackerController(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    Logger logger = LoggerFactory.getLogger(TrackerController.class);


    @RequestMapping(value = "/point/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public PointDTO[] createPoint(@RequestBody PointDTO[] pointDTO) throws IOException {
        for (int i = 0; i < pointDTO.length; i++) {
            logger.info(String.valueOf(pointDTO[i++]));

            FileWriter writer = new FileWriter("track.txt", true);
            writer.write(String.valueOf(pointDTO[i]));
            writer.flush();

        }
            return pointDTO;
        }

    }



