package com.example.demomovieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.TvDetail.class)
    private long id;

    @NotNull(message = "Number must not be blank")
    @Range(min = 1)
    @JsonView(View.TvDetail.class)
    private int season_number;

    @NotBlank(message = "Name must not be blank")
    @JsonView(View.TvDetail.class)
    private String name;

    @NotBlank(message = "Air date must not be blank")
    @JsonView(View.TvDetail.class)
    private String air_date;

    @JsonView(View.TvDetail.class)
    private String overview;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("tv")
    private Tv tv;

    @OneToMany(mappedBy = "season")
    @JsonIgnoreProperties("season")
    @JsonView(View.TvDetail.class)
    private Set<Episode> episode = new HashSet<>();

    public Season() {
    }

    public Season(long id, int season_number, String name, String air_date, String overview, Tv tv, Set<Episode> episode) {
        this.id = id;
        this.season_number = season_number;
        this.name = name;
        this.air_date = air_date;
        this.overview = overview;
        this.tv = tv;
        this.episode = episode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
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

    public Tv getTv() {
        return tv;
    }

    public void setTv(Tv tv) {
        this.tv = tv;
    }

    public Set<Episode> getEpisode() {
        return episode;
    }

    public void setEpisode(Set<Episode> episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", season_number=" + season_number +
                ", name='" + name + '\'' +
                ", air_date='" + air_date + '\'' +
                ", overview='" + overview + '\'' +
                ", tv=" + tv +
                ", episode=" + episode +
                '}';
    }
}
