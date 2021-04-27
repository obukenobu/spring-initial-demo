package com.csm.boot.initialboot.user;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class UserModel {
    @Id
    @SequenceGenerator(
            name="user_squence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private LocalDate dob;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserModel() {
    }

    public UserModel(long id,
                     String name,
                     String password,
                     String email,
                     String address,
                     LocalDate dob) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    public UserModel(String name,
                     String password,
                     String email,
                     String address,
                     LocalDate dob) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", age="+age+
                '}';
    }
}
