package com.u_tad.api_series.service;

import com.u_tad.api_series.model.Serie;
import com.u_tad.api_series.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public Serie saveOrUpdate(Serie serie) {
        return serieRepository.save(serie);
    }

}
