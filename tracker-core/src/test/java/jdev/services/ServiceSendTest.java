package jdev.services;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.BlockingDeque;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ServiceSendTest {
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    SendService sendService;

    @InjectMocks
    StorageService storageService;

    private PointDTO pointDTO;
    private String url ="http://localhost:8080/points";
    private PointDTO[] point;


    @Before
    public void setUp() throws Exception{
        pointDTO = new PointDTO();
        pointDTO.setLon(45.87);
        pointDTO.setLat(56.98);
        pointDTO.setAzimuth(345);
        pointDTO.setInstaSpeed(30);
        pointDTO.setAutoId("o567gfd");
        pointDTO.setTime(1502511617361L);
        point = new PointDTO[1];
        point[0] = pointDTO;
        storageService.put(point[0]);


    }



    @Test
    public void send() throws InterruptedException {
        when(restTemplate.postForObject(url,pointDTO,PointDTO.class)).thenReturn(pointDTO)
                .thenThrow(ResourceAccessException.class);
    BlockingDeque<PointDTO> result = storageService.getAll();
        assertNotNull(result);
        pointDTO.setLon(45.87);
        pointDTO.setLat(56.98);
        pointDTO.setAzimuth(345);
        pointDTO.setInstaSpeed(30);
        pointDTO.setAutoId("o567gfd");
        pointDTO.setTime(1502511617361L);
    }

}
