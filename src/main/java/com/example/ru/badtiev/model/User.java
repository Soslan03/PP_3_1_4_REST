package com.example.ru.badtiev.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name should be not Empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Second name should be not Empty")
    @Size(min = 2, max = 30, message = "Second name should be between 2 and 30 characters")
    @Column(name = "second_name")
    private String second_name;

    @Min(value = 0, message = "Age should be greater then 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email should be not Empty")
    @Email(message = "Email should be valid ")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String name, String second_name, int age, String email) {

        this.name = name;
        this.second_name = second_name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
