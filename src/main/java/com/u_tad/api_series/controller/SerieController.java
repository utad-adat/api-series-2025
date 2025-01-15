package com.u_tad.api_series.controller;

import com.u_tad.api_series.model.Serie;
import com.u_tad.api_series.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping
    public ResponseEntity<Serie> save(@RequestBody Serie serie) {
        // System.out.println("Llega => " + serie.getName());
        Serie serieNew = serieService.saveOrUpdate(serie);
        return ResponseEntity.ok(serieNew);
    }
}
