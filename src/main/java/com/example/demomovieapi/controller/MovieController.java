package com.example.demomovieapi.controller;

import com.example.demomovieapi.exception.ResourceNotFoundException;
import com.example.demomovieapi.model.Movie;
import com.example.demomovieapi.model.View;
import com.example.demomovieapi.repository.MovieRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value = "movie")
    @JsonView(View.MovieList.class)
    public ResponseEntity<Map<String, Object>> getAllTv(
            @RequestParam(required = false) String title,
            @RequestParam(required = false, defaultValue = "0") int genre,
            @RequestParam(required = false) String country,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        try {
            List<Movie> movieList = new ArrayList<Movie>();
            Pageable paging = PageRequest.of(page - 1, size);

            Page<Movie> moviePage;
            if (title != null) {
                moviePage = movieRepository.findByTitle(title, paging);
            } else if (genre != 0) {
                moviePage = movieRepository.findByGenre(genre, paging);
            } else if (country != null) {
                moviePage = movieRepository.findByCountry(country, paging);
            }
            else
                moviePage = movieRepository.findAll(paging);

            movieList = moviePage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", movieList);
            response.put("current_page", moviePage.getNumber() + 1);
            response.put("total_items", moviePage.getTotalElements());
            response.put("total_pages", moviePage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "movie/{id}")
    @JsonView(View.MovieDetail.class)
    public ResponseEntity<Movie> getTvById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid movie id : " + id));

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
