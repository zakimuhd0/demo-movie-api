package com.example.demomovieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.TvList.class)
    private long id;

    @NotBlank(message = "Title must not be blank")
    @JsonView(View.TvList.class)
    private String title;

    @NotBlank(message = "Overview must not be blank")
    @JsonView(View.TvDetail.class)
    private String overview;

    @NotBlank(message = "First air date must not be blank")
    @JsonView(View.TvDetail.class)
    private String first_air_date;

    @NotBlank(message = "Last air date must not be blank")
    @JsonView(View.TvDetail.class)
    private String last_air_date;

    @NotBlank(message = "Poster must not be blank")
    @JsonView(View.TvList.class)
    private String poster_path;

    @NotBlank(message = "Backdrop must not be blank")
    @JsonView(View.TvDetail.class)
    private String backdrop_path;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "tv_genre", joinColumns = @JoinColumn(name = "tv_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonIgnoreProperties("tvs")
    @JsonView(View.TvList.class)
    private Set<Genre> tv_genre_ids = new HashSet<>();

    @NotBlank(message = "Country must not be blank")
    private String country;

    @OneToMany(mappedBy = "tv")
    @JsonIgnoreProperties("tv")
    private Set<Season> season = new HashSet<>();

    public Tv() {
    }

    public Tv(long id, String title, String overview, String first_air_date, String last_air_date, String poster_path, String backdrop_path, Set<Genre> tv_genre_ids, String country, Set<Season> season) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.first_air_date = first_air_date;
        this.last_air_date = last_air_date;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.tv_genre_ids = tv_genre_ids;
        this.country = country;
        this.season = season;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Set<Genre> getTv_genre_ids() {
        return tv_genre_ids;
    }

    public void setTv_genre_ids(Set<Genre> tv_genre_ids) {
        this.tv_genre_ids = tv_genre_ids;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Season> getSeason() {
        return season;
    }

    public void setSeason(Set<Season> season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", first_air_date='" + first_air_date + '\'' +
                ", last_air_date='" + last_air_date + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", tv_genre_ids=" + tv_genre_ids +
                ", country='" + country + '\'' +
                ", season=" + season +
                '}';
    }
}
