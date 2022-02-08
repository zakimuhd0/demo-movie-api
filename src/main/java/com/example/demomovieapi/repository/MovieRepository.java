package com.example.demomovieapi.repository;

import com.example.demomovieapi.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select s from Movie s where title like %?1%")
    Page<Movie> findByTitle(String title, Pageable pageable);

    @Query("select e from Movie e join e.movie_country_ids u where u.id = :genreId")
    Page<Movie> findByGenre(long genreId, Pageable pageable);

    @Query("select e from Movie e join e.movie_country_ids u where u.name = :countryName")
    Page<Movie> findByCountry(String countryName, Pageable pageable);
}
