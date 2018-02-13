package jdev.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackServiceTest {

    @Test
    public void getGPS() throws JsonProcessingException {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLon(45.87);
        pointDTO.setLat(56.98);
        pointDTO.setAzimuth(345);
        pointDTO.setInstaSpeed(30);
        pointDTO.setAutoId("o567gfd");
        pointDTO.setTime(System.currentTimeMillis());
        assertTrue(pointDTO.toJson().contains("\"lat\":56.98"));
        assertTrue(pointDTO.toJson().contains("\"time\":"));
        assertTrue(pointDTO.toJson().contains("\"lon\":45.87"));
        assertTrue(pointDTO.toJson().contains("\"azimuth\":345"));
        assertTrue(pointDTO.toJson().contains("\"autoId\":"));
        assertTrue(pointDTO.toJson().contains("\"instaSpeed\":30"));
        System.out.println(pointDTO.toJson());
    }
}