package jdev.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdev.dto.IdPointDTO;
import jdev.dto.PointDTO;
import jdev.requests.ConstraintTrack;
import jdev.services.PointDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;


@RestController
public class TrackerController {

    /*private final RestTemplate restTemplate;

    public TrackerController(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
*/
    Logger log = LoggerFactory.getLogger(TrackerController.class);

    @Autowired
    PointDTOService pointDTOService;

    @RequestMapping(value = "/points", method = RequestMethod.POST, consumes = "application/json")
    public Boolean getCoordinates (@RequestBody String jsonPointDTO){
        try {
            ObjectMapper mapper = new ObjectMapper();
            PointDTO pointDTO = mapper.readValue(jsonPointDTO, PointDTO.class);
            log.info("getPoints: id = "+pointDTO.getAutoId()+"; lat = " + pointDTO.getLat() + "; lon = " + pointDTO.getLon()+"; " +
                    ";azimuth ="+pointDTO.getAzimuth()+", instaSpeed ="+pointDTO.getInstaSpeed()+"; time = "+pointDTO.getTime());
            PointDTO savePointDTO =  pointDTOService.create(pointDTO);

            BufferedWriter writer = new BufferedWriter(new FileWriter("track.txt", true));
            writer.write(String.valueOf("saved points: id = " + savePointDTO.getAutoId() + "; " +
                            "lat = " + savePointDTO.getLat() + "; lon = " + savePointDTO.getLon()+ ";azimuth ="+savePointDTO.getAzimuth()
            +", instaSpeed ="+savePointDTO.getInstaSpeed()+"; time = "+savePointDTO.getTime()));
            writer.newLine();
            writer.flush();

            return true;
        }
        catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }
    @CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
    @RequestMapping(value="/track", method = RequestMethod.POST, produces ="application/json")
    public List<PointDTO> getLastNRecords(@RequestBody String jsonTrack){
        try {
            ObjectMapper mapper = new ObjectMapper();
            ConstraintTrack constraintTrack = mapper.readValue(jsonTrack, ConstraintTrack.class);
            List<PointDTO> points =  pointDTOService.getLastNRecords(constraintTrack.getAutoId(),constraintTrack.getPointCount());
            Collections.reverse(points);
            return points;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
    @RequestMapping(value="/deletePoint", method = RequestMethod.POST)
    public String deleteRecord (@RequestBody String jsonTrack){
        try {
            ObjectMapper mapper = new ObjectMapper();
            IdPointDTO idPoint = mapper.readValue(jsonTrack, IdPointDTO.class);
            PointDTO pointDTO = pointDTOService.findById(idPoint);
            pointDTOService.delete(pointDTO);
            return "{\"message\":\"Запись успешно удалена\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
    @RequestMapping(value="/createPoint", method = RequestMethod.POST)
    public PointDTO createRecord (@RequestBody String jsonTrack){
        try {
            ObjectMapper mapper = new ObjectMapper();
            PointDTO pointDTO = mapper.readValue(jsonTrack, PointDTO.class);
            return pointDTOService.create(pointDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
    @RequestMapping(value="/editPoint", method = RequestMethod.POST)
    public PointDTO editRecord (@RequestBody String jsonTrack){
        try {
            ObjectMapper mapper = new ObjectMapper();
            PointDTO pointDTO = mapper.readValue(jsonTrack, PointDTO.class);
            return pointDTOService.update(pointDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}



