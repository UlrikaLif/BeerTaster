package com.project.beertaster.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="beer_sorts")
public class BeerSort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "beerSort")
    private Set<Grade> grades;

    private String name;
    private String category;
    private String brewery;
    private String country;


    // Constructor
    public BeerSort() {

    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }




    // ToString-method


    @Override
    public String toString() {
        return "BeerSort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", brewery='" + brewery + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}