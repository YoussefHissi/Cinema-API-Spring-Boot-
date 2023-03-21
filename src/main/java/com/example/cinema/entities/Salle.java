package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40)
    private String name;

    private int nombrePlace;
    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "salle")
    Collection<Place> Places;


    @OneToMany(mappedBy = "salle")
    Collection<Projection> Projections;

}
