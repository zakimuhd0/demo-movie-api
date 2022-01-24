package com.example.demomovieapi.controller;

import com.example.demomovieapi.exception.ResourceNotFoundException;
import com.example.demomovieapi.model.Episode;
import com.example.demomovieapi.model.Tv;
import com.example.demomovieapi.repository.EpisodeRepository;
import com.example.demomovieapi.repository.SeasonRepository;
import com.example.demomovieapi.repository.TvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "api/v1/")
public class EpisodeController {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TvRepository tvRepository;

    @PostMapping(value = "tv/{tvid}/season/{seasonid}/episode")
    public Episode create(@PathVariable("tvid") @Min(1) long tvid, @PathVariable("seasonid") @Min(1) long seasonid, @RequestBody Episode episode) throws ResourceNotFoundException {
        Tv tv = tvRepository.findById(tvid)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid tv id : " + tvid));

        return seasonRepository.findById(seasonid).map(season -> {
            episode.setSeason(season);
            return episodeRepository.save(episode);
        }).orElseThrow(() -> new ResourceNotFoundException("Invalid season id : " + seasonid));
    }
}
