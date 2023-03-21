package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    @Column(length = 20)
    private double longitude,latitude,altitude;

    @ManyToOne
    private Salle salle;

    @OneToMany(mappedBy = "place")
    Collection<Ticket> tickets;
}
