package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String Description;
    private String Realisateur;
    private Date dateSortie;
    private double Duree;
    private String Photo;

    @OneToMany(mappedBy = "film")
    private Collection<Projection> projections;

    @ManyToOne
    private com.example.cinema.entities.Category Category;
}
