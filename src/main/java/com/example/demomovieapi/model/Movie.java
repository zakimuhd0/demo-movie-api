package com.example.demomovieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.MovieList.class)
    private long id;

    @NotBlank(message = "Title must not be blank")
    @JsonView(View.MovieList.class)
    private String title;

    @NotBlank(message = "Overview must not be blank")
    @JsonView(View.MovieDetail.class)
    private String overview;

    @NotBlank(message = "Release date must not be blank")
    @JsonView(View.MovieDetail.class)
    private String release_date;

    @NotBlank(message = "Poster must not be blank")
    @JsonView(View.MovieList.class)
    private String poster_path;

    @NotBlank(message = "Backdrop must not be blank")
    @JsonView(View.MovieDetail.class)
    private String backdrop_path;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonIgnoreProperties("movies")
    @JsonView(View.MovieList.class)
    private Set<Genre> movie_genre_ids = new HashSet<>();

    @NotBlank(message = "Country must not be blank")
    private String country;

    public Movie() {
    }

    public Movie(long id, String title, String overview, String release_date, String poster_path, String backdrop_path, Set<Genre> movie_genre_ids, String country) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.movie_genre_ids = movie_genre_ids;
        this.country = country;
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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
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

    public Set<Genre> getMovie_genre_ids() {
        return movie_genre_ids;
    }

    public void setMovie_genre_ids(Set<Genre> movie_genre_ids) {
        this.movie_genre_ids = movie_genre_ids;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", movie_genre_ids=" + movie_genre_ids +
                ", country='" + country + '\'' +
                '}';
    }
}
