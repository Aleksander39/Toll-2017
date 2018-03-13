package jdev.core;

import jdev.core.dao.Point;
import jdev.core.dao.repo.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class})
@EnableJpaRepositories("jdev.core.dao")
@EntityScan(basePackageClasses = jdev.core.dao.Point.class)
@ComponentScan("jdev.services")
@PropertySource("classpath:/app.properties")
public class JpaApplication   implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<Point> allPoint;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean

    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    PointRepository pointRepository;


    public void run(String... args) throws Exception {

      readPoint();

        Point point1 = create(140.64707900, 44.14411900, 1502511617361L, 30.0, 60,"o223g");
        Point point2 = create(141.64707900, 45.14411900, 1502511617361L, 34.0, 160,"e456ut");
        log.info("=========== after create");
        readPoint();

        update(point1, 143.64707900, 44.14411900, 1502511617361L, 30.0, 60,"o223g");
        update(point2, 145.64707900, 56.14411900, 1502511617361L, 35.0, 20,"e456ut");
        log.info("=========== after update");
        readPoint();


        delete(point1);
        log.info("=========== after delete 1");
        readPoint();

        delete(point2);
        log.info("=========== after delete 2");
        readPoint();

        delete(point1);
        log.info("=========== after delete 3");
        readPoint();


    }

    private void delete(Point point) {
        pointRepository.delete(point);
    }


    private void update(Point point, Double lat, Double lon, Long time, Double azimuth, Integer instaSpeed,String autoId) {
        point.setLat(lat);
        point.setLon(lon);
        point.setTime(time);
        point.setAzimuth(azimuth);
        point.setSpeed(instaSpeed);
        point.setAutoId(autoId);
        pointRepository.save(point);
    }


    private void readPoint() {
        allPoint = (List<Point>) pointRepository.findAll();

        if (allPoint.size() == 0) {
            log.info("NO RECORDS POINT");
        } else {
            allPoint.stream().forEach(point -> log.info(point.toString()));
        }
    }

    private Point create(Double lat, Double lon, Long time, Double azimuth, Integer instaSpeed,String autoId) {
        Point point = new Point();
        point.setLat(lat);
        point.setLon(lon);
        point.setTime(time);
        point.setAzimuth(azimuth);
        point.setSpeed(instaSpeed);
        point.setAutoId(autoId);
        return pointRepository.save(point);
}
}




