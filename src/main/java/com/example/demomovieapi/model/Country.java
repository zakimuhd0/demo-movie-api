package com.example.demomovieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.TvList.class, View.MovieList.class})
    private long id;

    @NotBlank(message = "Name must not be blank")
    @JsonView({View.TvList.class, View.MovieList.class})
    private String name;

    @ManyToMany(mappedBy = "tv_country_ids", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("tv_country_ids")
    private Set<Tv> tvs = new HashSet<>();

    @ManyToMany(mappedBy = "movie_country_ids", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("movie_country_ids")
    private Set<Movie> movies = new HashSet<>();
}
