package web.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstname;

    public User() {
    }

    public User(Long id, String name, String firstname) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    @Override
    public String toString() {
        return name + " " + firstname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
