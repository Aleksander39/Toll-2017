package jdev.tracker.ui;

import jdev.dto.PointDTO;

/**
 * Created by jdev on 07.03.2017.
 */
public class Main {
    public static void main(String... args) throws Exception {
        for (int i=0; i<5; i++) {
            System.out.println("Main.main say Hello!!!!");
            PointDTO pointDTO = new PointDTO();
            pointDTO.setLat(45);
            System.out.println(pointDTO.toJson());
            Thread.sleep(1000);
        }
    }
}
