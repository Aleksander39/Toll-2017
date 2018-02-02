package jdev.services;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@ComponentScan({"services","controllers"})
public class Main {

    public static void main(String[] args) throws IOException {

        //String s = IOUtils.toString(new URL("http://localhost:8080/counter?name=The+Who"), "UTF8");
    }
}
