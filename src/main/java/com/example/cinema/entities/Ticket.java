package com.example.cinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NameClient;
    private Double prix;
    @Column(unique = true)
    private int CodePayement;
    private boolean reserve;

    @ManyToOne
    private Place place;
    @ManyToOne
    private Projection projection;


}
