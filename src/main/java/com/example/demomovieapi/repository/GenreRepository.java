package com.example.demomovieapi.repository;

import com.example.demomovieapi.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
