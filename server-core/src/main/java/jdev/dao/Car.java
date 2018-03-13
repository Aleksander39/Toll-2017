package jdev.dao;


import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "BRAND", length = 32, nullable = false)
    String brand;

    @Column(name = "ID_CAR", length = 8, nullable = false, unique = true)
    String idCar;

    @Column(name = "MODEL", length = 32,  nullable = false)
    String model;

   /* @OneToOne(optional = false,mappedBy = "point")
    Point point;*/

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "cars")
    java.util.Set<User> users = new HashSet<>();

    public String toString() {
        return "Car{ id=" + id + ", idCar=" + idCar + ", brand=" + brand + ", model=" + model +" }";
    }

    public Car( Integer id,String idCar, String brand, String model) {
        this.idCar = idCar;
        this.brand = brand;
        this.model = model;
        this.id = id;
    }
    public Car(Integer id, String idCar, String brand, String model, Set<User> users) {
        this.id = id;
        this.idCar = idCar;
        this.brand = brand;
        this.model = model;
        this.users = users;
    }
public Car(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setUsers(java.util.Set<User> users) {
        this.users = users;
    }

   /* public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }*/
}
