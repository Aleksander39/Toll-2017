package jdev.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GPSMain {
    public static void main(String...args){
        ApplicationContext context= new AnnotationConfigApplicationContext(GPSContext.class);

    }
}
