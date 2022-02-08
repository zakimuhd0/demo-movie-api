package com.example.demomovieapi.repository;

import com.example.demomovieapi.model.Tv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TvRepository extends JpaRepository<Tv, Long> {

    @Query("select s from Tv s where title like %?1%")
    Page<Tv> findByTitle(String title, Pageable pageable);

    @Query("select e from Tv e join e.tv_genre_ids u where u.id = :genreId")
    Page<Tv> findByGenre(long genreId, Pageable pageable);

    @Query("select e from Tv e join e.tv_country_ids u where u.name = :countryName")
    Page<Tv> findByCountry(String countryName, Pageable pageable);
}
