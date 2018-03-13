package jdev.controllers;

import jdev.dao.Point;
import jdev.dao.repo.PointRepository;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class TrackerController {

    private final RestTemplate restTemplate;

    public TrackerController(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    Logger logger = LoggerFactory.getLogger(TrackerController.class);

    @Autowired
    PointRepository pointRepository;


    @RequestMapping(value = "/points", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public PointDTO[] createPoint(@RequestBody PointDTO[] pointDTO) throws IOException {
        for (int i = 0; i < pointDTO.length; i++) {
            logger.info(String.valueOf(pointDTO[i]));
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("track.txt", true));
                writer.write(String.valueOf(pointDTO[i]));
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                logger.info(ex.getMessage());
            }


        }
        return pointDTO;
    }

    @RequestMapping(value = "/points", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public PointDTO[] getByTime(@RequestParam("auto-id") String autoId, @RequestParam long hours) {
        long millis = TimeUnit.HOURS.toMillis(hours);
        List<jdev.dao.Point> allPoints = (List<jdev.dao.Point>) pointRepository.filterByTime(
                autoId,
                millis,
                System.currentTimeMillis()
        );

        int i = 0;
        PointDTO[] points = new PointDTO[ allPoints.size()];
        for (jdev.dao.Point entityPoint : allPoints) {
            PointDTO point = new PointDTO();
            point.setLat(entityPoint.getLat());
            point.setLon(entityPoint.getLon());
            point.setAzimuth(entityPoint.getAzimuth());
            point.setInstaSpeed(entityPoint.getSpeed());
            point.setTime(entityPoint.getTime());
            point.setAutoId(entityPoint.getCar().getIdCar());

            points[i++] = point;
        }

        return points;

    }
}



