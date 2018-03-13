package jdev.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;



@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "FIRST_NAME", nullable = false)
    String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    String lastName;


    @Column(name = "DATE_BIRTH", nullable = false)
    String dateBirth;

    @OneToOne(optional = false)
    @JoinColumn(name = "role_id",unique = true, nullable = false, updatable = false)
    private Role role;




    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_CAR", joinColumns = {
            @JoinColumn(name = "USER_ID", nullable = false, updatable = false)
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "ID_CAR", nullable = false, updatable = false)
            }
    )
    java.util.Set<Car> cars = new HashSet<>();

    public User(Integer id, String firstName, String lastName, String dateBirth,Role role, Set<Car> cars) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.role = role;
        this.cars = cars;
    }
    public User() {
    }


    public String toString() {
        return "User{ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
                + ", dateBirth=" + dateBirth + ",role ="+role+","+cars+" }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

}
