package jdev.dto;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PointDTOTest {
    @Test
    public void toJson() throws Exception {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(56);
        pointDTO.setLon(74);
        pointDTO.setAutoId("o567gfd");
        assertTrue(pointDTO.toJson().contains("\"lat\":56"));
        System.out.println(pointDTO.toJson());

    }



}
