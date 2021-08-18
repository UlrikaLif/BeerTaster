package com.project.beertaster.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    Set<Grade> grades;

    @Column(name="user_name")
    private String username;
    private String password;



    // Constructor

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }


    // ToString method

    /// ******    Ska kanske tas bort ****** ///
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}