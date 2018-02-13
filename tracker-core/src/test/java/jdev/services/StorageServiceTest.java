package jdev.services;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StorageServiceTest {

    @InjectMocks
    StorageService storageService;

    @Before
    public void setUp() throws Exception {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLon(45.87);
        pointDTO.setLat(56.98);
        pointDTO.setAzimuth(345);
        pointDTO.setInstaSpeed(30);
        pointDTO.setAutoId("o567gfd");
        pointDTO.setTime(System.currentTimeMillis());
        storageService.put(pointDTO);
    }

    @Test
    public void take() throws InterruptedException {
        PointDTO result = storageService.take();
        assertNotNull(result);
        assertEquals(56.98, result.getLat(), 0);
        assertEquals(45.87, result.getLon(), 0);
        assertEquals(345, result.getAzimuth(), 0);
        assertEquals(30, result.getInstaSpeed(), 0);
        assertEquals("o567gfd", result.getAutoId());
    }



    @Test
    public void getAll() {
        assertNotNull(storageService.getAll());
    }
}