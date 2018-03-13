package jdev.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "NAME", length = 32, nullable = false)
    String name;

   /* @OneToOne(optional = false,mappedBy = "user")
    User user;
*/
    public Role(String name) {
        this.name = name;
    }
    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }



    public String toString() {
        return "Role{ id=" + id + ", name=" + name + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
