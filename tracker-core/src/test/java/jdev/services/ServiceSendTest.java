package jdev.services;

import jdev.dto.PointDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ServiceSendTest {
    @Mock
    RestTemplate restTemplate;

    private PointDTO pointDTO;
    private String url ="http://localhost:8080/points";


    @Before
    public void setUp() throws Exception{
        pointDTO = new PointDTO();
        pointDTO.setLon(45.87);
        pointDTO.setLat(56.98);
        pointDTO.setAzimuth(345);
        pointDTO.setInstaSpeed(30);
        pointDTO.setAutoId("o567gfd");
        pointDTO.setTime(System.currentTimeMillis());
    }



    @Test
    public void send() {
        when(restTemplate.postForObject(url,pointDTO,PointDTO.class)).thenReturn(pointDTO)
                .thenThrow(ResourceAccessException.class);
    }
}
