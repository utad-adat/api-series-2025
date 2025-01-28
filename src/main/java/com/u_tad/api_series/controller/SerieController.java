package com.u_tad.api_series.controller;

import com.u_tad.api_series.model.ApiResponse;
import com.u_tad.api_series.model.Serie;
import com.u_tad.api_series.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping
    public ResponseEntity<ApiResponse<Serie>> update(@RequestBody Serie serie) {
        // System.out.println("Llega => " + serie.getName());
        try {
            Serie serieNew = serieService.saveOrUpdate(serie);
            return ResponseEntity.ok(new ApiResponse<>(true, "Serie actualizada", serieNew));
        } catch (Exception e) {
            System.out.println("Error => " + e.getMessage());
            return ResponseEntity.badRequest().body(new ApiResponse<>(false, "Error " + e.getMessage(), null));
        }
    }


}
