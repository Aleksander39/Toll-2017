package jdev.controllers;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TrackerController {
    Logger logger = LoggerFactory.getLogger(TrackerController.class);

    @RequestMapping(value = "/coords", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
     public PointDTO receive(@RequestBody PointDTO pointDTO){
        logger.info(String.valueOf(pointDTO));
        try(FileWriter writer = new FileWriter("track.txt", true)) {
            writer.write(String.valueOf(pointDTO));
            writer.flush();
        }
        catch(IOException ex) {
            logger.info(ex.getMessage());
        }

        return pointDTO;

     }

}
