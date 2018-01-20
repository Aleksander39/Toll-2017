package jdev.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;

@Service
public class GPSService {

    int d = 1;
    int f = 0;

    public String getGPS() throws JsonProcessingException {
        PointDTO pointDTO = new PointDTO();
        double lat = (Math.random() * 20.3);
        double lon = (Math.random() * 41.2);
        int instaSpeed = (int) (Math.random() * 100);
        if (d > f) {
            pointDTO.setLat(lat);
            pointDTO.setLon(lon);
            pointDTO.setAzimuth(238.6);
            pointDTO.setInstaSpeed(instaSpeed);
            pointDTO.setAutoId("o567gfd");
            pointDTO.setTime(System.currentTimeMillis());
            d++;
        }
        return pointDTO.toJson();
    }
}
