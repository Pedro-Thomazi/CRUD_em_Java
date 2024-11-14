package br.com.crudDeUsuariosJava.crudUsers.domain.usuario;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "users")
@Entity(name = "User")
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private Boolean active;

    public User(DataUser data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.gender = data.gender();
        this.age = data.age();
        this.active = true;
    }

    public void updateUser(DataUpdateUser data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.age() != 0) {
            this.age = data.age();
        }
    }

    public void deleteUser() {
        this.active = false;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Boolean getActive() {
        return active;
    }
}
