package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointDTOTest {
    private final String autoId = "o567gfd";
    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1513326123814}";

    @Test
    public void toJson() throws Exception {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(56);
        pointDTO.setLon(74);
        pointDTO.setAutoId("o567gfd");
        assertTrue(pointDTO.toJson().contains("\"lat\":56"));
        assertTrue(pointDTO.toJson().contains("\"time\":"));
        System.out.println(pointDTO.toJson());

    }
    @Test
    public void decodeDTO()throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(expected,PointDTO.class);
        assertEquals(autoId,dto.getAutoId());
        assertEquals(1513326123814L,dto.getTime());
        System.out.println(dto.toJson());
    }




}
