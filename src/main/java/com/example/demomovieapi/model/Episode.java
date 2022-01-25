package com.example.demomovieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.TvDetail.class)
    private long id;

    @NotNull(message = "Number must not be blank")
    @Range(min = 1)
    @JsonView(View.TvDetail.class)
    private int episode_number;

    @NotBlank(message = "Name must not be blank")
    @JsonView(View.TvDetail.class)
    private String name;

    @NotBlank(message = "Air date must not be blank")
    @JsonView(View.TvDetail.class)
    private String air_date;

    @JsonView(View.TvDetail.class)
    private String overview;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("season")
    private Season season;

    public Episode() {
    }

    public Episode(long id, int episode_number, String name, String air_date, String overview, Season season) {
        this.id = id;
        this.episode_number = episode_number;
        this.name = name;
        this.air_date = air_date;
        this.overview = overview;
        this.season = season;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", episode_number=" + episode_number +
                ", name='" + name + '\'' +
                ", air_date='" + air_date + '\'' +
                ", overview='" + overview + '\'' +
                ", season=" + season +
                '}';
    }
}
