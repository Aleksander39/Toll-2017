package jdev.jpa;

import jdev.dao.Car;
import jdev.dao.Point;
import jdev.dao.Role;
import jdev.dao.User;
import jdev.dao.repo.CarRepository;
import jdev.dao.repo.PointRepository;
import jdev.dao.repo.RoleRepository;
import jdev.dao.repo.UserRepository;
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
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class})
@EnableJpaRepositories("jdev.dao")
@ComponentScan({"jdev.controllers"})
@EntityScan(basePackageClasses = {jdev.dao.Role.class, jdev.dao.Point.class, jdev.dao.Car.class, jdev.dao.User.class})
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<Car> allCar;
    private List<Role> allRole;
    private List<User> allUser;
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

    @Autowired
    CarRepository carRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Car car1 = new Car(1,"и122ип70","KAMAZ","54115");

        Set<Car> cars = new HashSet<>();
        Set<User> users = new HashSet<>();

       cars.add(car1);

        readRole();
        readUser();
        readCar();
        readPoint();

        Role client = create("client1");
        Role manager = create("manager1");
        Role root = create("root1");
        log.info("=========== after create");
        readRole();

        User petrov= create(1,"Иван","Петров","14/02/1985",new Role(1,"client"),cars);
        User suchkov = create(2,"Сергей", "Сушков", "13/09/1978", new Role(2,"manager"), cars);
        User gonsov = create(3, "Павел", "Гонцов",  "14/10/1964", new Role(3, "root"), cars);
        readUser();


        users.add(gonsov);
        Car и122ип70 = create(1,"и122ип70", "KAMAZ", "54115", users);
        Car с001сс70 = create(2, "с001сс70", "MAZ", "5440", users);
        Car п888пг70 = create(3, "п888пг70", "MERCEDES-BENZ", "6X2", users);
        readCar();

        Point point1 = create(154.64707900, 44.14411900, new Car(1,"и122ип70","KAMAZ","54115"),
                1502511617361L, 30.0, 60);
        Point point2 = create(135.64701800, 45.14414700,new Car(1,"и122ип70","KAMAZ","54115"),
                1502511635127L, 35.0, 56);
        Point point3 = create(111.64718700, 46.14444000, new Car(1,"и122ип70","KAMAZ","54115"),
                1502511655168L, 40.0, 63);
        readPoint();


        update(client, "client");
        update(manager, "manager");
        update(root, "root");
        log.info("=========== after update");
        readRole();

        update(petrov, "Иван", "Петров", "14/02/1985", new Role(1,"client"),cars);
        update(suchkov, "Сергей", "Сушков", "13/09/1978", new Role(2,"manager"),cars);
        update(gonsov,  "Павел", "Гонцов", "14/10/1964", new Role(3,"root"),cars);
        log.info("=========== after update");
        readUser();

        update(и122ип70, "и122ип70", "KAMAZ", "54115");
        update(с001сс70, "с001сс70", "MAZ", "5440");
        update(п888пг70, "п888пг70", "MERCEDES-BENZ", "6X2");
        log.info("=========== after update");
        readCar();

        update(point1, 135.64707900, 44.14411900, new Car(1,"и122ип70", "KAMAZ", "54115"),
                1502511617361L, 30.0, 63);
        update(point2, 135.64701800, 44.14414700, new Car(1,"и122ип70","KAMAZ","54115"),
                1502511635127L, 35.0, 55);
        update(point3, 135.64718700, 44.14444000, new Car(1,"и122ип70","KAMAZ","54115"),
                1502511655168L, 40.0, 65);
        log.info("=========== after update");
        readPoint();


        delete(client);
        log.info("=========== after delete 1");
        readRole();

        delete(manager);
        log.info("=========== after delete 2");
        readRole();

        delete(root);
        log.info("=========== after delete 3");
        readRole();

        delete(petrov);
        log.info("=========== after delete 1");
        readUser();

        delete(suchkov);
        log.info("=========== after delete 2");
        readUser();

        delete(gonsov);
        log.info("=========== after delete 3");
        readUser();

        delete(gonsov);
        log.info("=========== after delete 4");
        readUser();

        delete(и122ип70);
        log.info("=========== after delete 1");
        readCar();

        delete(с001сс70);
        log.info("=========== after delete 2");
        readCar();

        delete(п888пг70);
        log.info("=========== after delete 3");
        readCar();

       /*delete(п888пг70);
        l og.info("=========== after delete 3");
        readCar();*/

        delete(petrov);
        log.info("=========== after delete 1");
        readUser();

        delete(suchkov);
        log.info("=========== after delete 2");
        readUser();

        delete(gonsov);
        log.info("=========== after delete 3");
        readUser();

        delete(gonsov);
        log.info("=========== after delete 4");
        readUser();

        delete(point1);
        log.info("=========== after delete 1");
        readPoint();

        delete(point2);
        log.info("=========== after delete 2");
        readPoint();

        delete(point3);
        log.info("=========== after delete 3");
        readPoint();

        delete(client);
        log.info("=========== after delete 1");
        readRole();

        delete(manager);
        log.info("=========== after delete 2");
        readRole();

        delete(root);
        log.info("=========== after delete 3");
        readRole();
    }

    private void delete(Car car) {
        carRepository.delete(car);
    }

    private void update(Car car, String idCar, String brand, String model) {
        car.setIdCar(idCar);
        car.setBrand(brand);
        car.setModel(model);
        carRepository.save(car);
    }

    private void readCar() {
        allCar = (List<Car>) carRepository.findAll();

        if (allCar.size() == 0) {
            log.info("NO RECORDS AUTO");
        } else {
            allCar.stream().forEach(car -> log.info(car.toString()));
        }
    }

    private Car create(Integer id, String idCar, String brand, String model, Set<User> users) {
        Car car = new Car();
        car.setId(id);
        car.setIdCar(idCar);
        car.setBrand(brand);
        car.setModel(model);

        if(users != null && users.size() > 0) {
            car.setUsers(users);
        }

        return carRepository.save(car);
    }

    private void delete(Role role) {
        roleRepository.delete(role);
    }

    private void update(Role role,  String name) {
        role.setName(name);
        roleRepository.save(role);
    }

    private void readRole() {
        allRole = (List<Role>) roleRepository.findAll();

        if (allRole.size() == 0) {
            log.info("NO RECORDS ROLE");
        } else {
            allRole.stream().forEach(role -> log.info(role.toString()));
        }
    }

    private Role create(String name) {
        Role role = new Role();
        role.setName(name);
        return roleRepository.save(role);
    }

    private void delete(Point point) {
        pointRepository.delete(point);
    }

    private void update(Point point, Double lat, Double lon, Car car, Long time, Double azimuth, Integer instaSpeed) {
        point.setLat(lat);
        point.setLon(lon);
        point.setCar(car);
        point.setTime(time);
        point.setAzimuth(azimuth);
        point.setSpeed(instaSpeed);
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

    private Point create(Double lat, Double lon, Car car, Long time, Double azimuth, Integer instaSpeed) {
        Point point = new Point();
        point.setLat(lat);
        point.setLon(lon);
        point.setCar(car);
        point.setTime(time);
        point.setAzimuth(azimuth);
        point.setSpeed(instaSpeed);
        return pointRepository.save(point);
    }


    private void delete(User user) {
        userRepository.delete(user);
    }

    private void update(User user, String firstName, String lastName, String dateOfBirth, Role role,Set<Car> cars) {
        user.setDateBirth(dateOfBirth);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        user.setCars(cars);
        userRepository.save(user);
    }

    private void readUser() {
        allUser = (List<User>) userRepository.findAll();

        if (allUser.size() == 0) {
            log.info("NO RECORDS USER");
        } else {
            allUser.stream().forEach(user -> log.info(user.toString()));
        }
    }

    private User create(Integer id, String firstName, String lastName,  String dateBirth, Role role, Set<Car> cars) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateBirth(dateBirth);
        user.setRole(role);
        user.setCars(cars);

        return userRepository.save(user);
    }
}
