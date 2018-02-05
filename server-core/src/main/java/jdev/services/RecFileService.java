package jdev.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class RecFileService {
    private File file = new File("server-core//src//main//resources//point//coords.txt");
        public void writeInFile(String text){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


