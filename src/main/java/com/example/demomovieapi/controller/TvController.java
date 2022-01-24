package com.example.demomovieapi.controller;

import com.example.demomovieapi.exception.ResourceNotFoundException;
import com.example.demomovieapi.model.Tv;
import com.example.demomovieapi.model.View;
import com.example.demomovieapi.repository.TvRepository;
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
public class TvController {

    @Autowired
    private TvRepository tvRepository;

    @GetMapping(value = "tv")
    @JsonView(View.TvList.class)
    public ResponseEntity<Map<String, Object>> getAllTv(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<Tv> tvList = new ArrayList<Tv>();
            Pageable paging = PageRequest.of(page - 1, size);

            Page<Tv> tvPage;
            if (title == null)
                tvPage = tvRepository.findAll(paging);
            else
                tvPage = tvRepository.findByTitle(title, paging);

            tvList = tvPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", tvList);
            response.put("currentPage", tvPage.getNumber() + 1);
            response.put("totalItems", tvPage.getTotalElements());
            response.put("totalPages", tvPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "tv/{id}")
    @JsonView(View.TvDetail.class)
    public ResponseEntity<Tv> getTvById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Tv tv = tvRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid tv id : " + id));

        return new ResponseEntity<>(tv, HttpStatus.OK);
    }
}
