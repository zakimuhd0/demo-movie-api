package com.example.demomovieapi.controller;

import com.example.demomovieapi.exception.ResourceNotFoundException;
import com.example.demomovieapi.model.Season;
import com.example.demomovieapi.repository.SeasonRepository;
import com.example.demomovieapi.repository.TvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "api/v1/")
public class SeasonController {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TvRepository tvRepository;

    @PostMapping(value = "tv/{id}/season")
    public Season create(@PathVariable("id") @Min(1) long id, @RequestBody Season season) throws ResourceNotFoundException {
        return tvRepository.findById(id).map(tv -> {
            season.setTv(tv);
            return seasonRepository.save(season);
        }).orElseThrow(() -> new ResourceNotFoundException("Invalid tv id : " + id));
    }
}
