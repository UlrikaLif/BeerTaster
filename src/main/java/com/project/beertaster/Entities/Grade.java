package com.project.beertaster.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    
    @ManyToOne
    @JoinColumn(name = "beer_id")
    private BeerSort beerSort;

    @Column(name ="given_grade")
    private int givenGrade;

    private String opinion;
    private String appearance;
    private String fragrance;

    private String bitterness;
    private String fullness;
    private String freshness;
    private String sweetness;


    // Constructor

    public Grade() {
    }


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BeerSort getBeerSort() {
        return beerSort;
    }

    public void setBeerSort(BeerSort beerSort) {
        this.beerSort = beerSort;
    }

    public int getGivenGrade() {
        return givenGrade;
    }

    public void setGivenGrade(int givenGrade) {
        this.givenGrade = givenGrade;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getFragrance() {
        return fragrance;
    }

    public void setFragrance(String fragrance) {
        this.fragrance = fragrance;
    }

    public String getBitterness() {
        return bitterness;
    }

    public void setBitterness(String bitterness) {
        this.bitterness = bitterness;
    }

    public String getFullness() {
        return fullness;
    }

    public void setFullness(String fullness) {
        this.fullness = fullness;
    }

    public String getFreshness() {
        return freshness;
    }

    public void setFreshness(String freshness) {
        this.freshness = freshness;
    }

    public String getSweetness() {
        return sweetness;
    }

    public void setSweetness(String sweetness) {
        this.sweetness = sweetness;
    }




    // ToString method

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", user=" + user +
                ", beerSort=" + beerSort +
                ", givenGrade=" + givenGrade +
                ", opinion='" + opinion + '\'' +
                ", appearance='" + appearance + '\'' +
                ", fragrance='" + fragrance + '\'' +
                ", bitterness='" + bitterness + '\'' +
                ", fullness='" + fullness + '\'' +
                ", freshness='" + freshness + '\'' +
                ", sweetness='" + sweetness + '\'' +
                '}';
    }
}