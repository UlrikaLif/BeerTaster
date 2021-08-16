package com.project.beertaster.Entities;

import javax.persistence.*;

@Entity
@Table(name="grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int user_id;
    private int beer_id;

    private int grade;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBeer_id() {
        return beer_id;
    }

    public void setBeer_id(int beer_id) {
        this.beer_id = beer_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
                ", user_id=" + user_id +
                ", beer_id=" + beer_id +
                ", grade=" + grade +
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
