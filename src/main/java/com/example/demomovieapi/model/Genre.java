package com.example.demomovieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.TvList.class, View.MovieList.class})
    private long id;

    @NotBlank(message = "Name must not be blank")
    @JsonView({View.TvList.class, View.MovieList.class})
    private String name;

    @ManyToMany(mappedBy = "tv_genre_ids", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("tv_genre_ids")
    private Set<Tv> tvs = new HashSet<>();

    @ManyToMany(mappedBy = "movie_genre_ids", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("movie_genre_ids")
    private Set<Movie> movies = new HashSet<>();

    public Genre() {
    }

    public Genre(long id, String name, Set<Tv> tvs, Set<Movie> movies) {
        this.id = id;
        this.name = name;
        this.tvs = tvs;
        this.movies = movies;
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

    public Set<Tv> getTvs() {
        return tvs;
    }

    public void setTvs(Set<Tv> tvs) {
        this.tvs = tvs;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tvs=" + tvs +
                ", movies=" + movies +
                '}';
    }
}
