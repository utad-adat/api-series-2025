package com.u_tad.api_series.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "adat_series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;

    @Column(nullable = false)
    private String name;
    private String genre;
    private Integer year;
    private Integer ranking;

}
