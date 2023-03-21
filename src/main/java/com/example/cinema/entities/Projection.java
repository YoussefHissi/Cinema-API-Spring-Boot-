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
public class Projection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date DateProjection;
    private Double Prix ;
    @ManyToOne
    private Salle salle;

    @ManyToOne
    private Film film;

    @OneToMany(mappedBy = "projection")
    Collection<Ticket> tickets;

}
