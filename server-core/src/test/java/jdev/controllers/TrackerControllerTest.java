package jdev.controllers;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TrackerControllerTest {

    private PointDTO[] point;

    @Before
    public void setUp() throws Exception{
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLon(45.87);
        pointDTO.setLat(56.98);
        pointDTO.setAzimuth(345);
        pointDTO.setInstaSpeed(30);
        pointDTO.setAutoId("o567gfd");
        pointDTO.setTime(1502511617361L);
        point = new PointDTO[1];
        point[0] = pointDTO;
    }

    @Test
    public void createPointIntegration() throws Exception {
        PointDTO[] result = new TrackerController(new RestTemplate()).createPoint(point);
        assertNotNull(result);
        assertEquals(result[0].getLat(), 56.98, 0);
        assertEquals(result[0].getLon(), 45.87, 0);
        assertEquals(result[0].getAutoId(), "o567gfd");
        assertEquals(result[0].getTime(), 1502511617361L);
        assertEquals(result[0].getAzimuth(), 345, 0);
        assertEquals(result[0].getInstaSpeed(), 30, 0);
    }

}
