package com.example.cinema.init;

import com.example.cinema.dao.CinemaRepository;
import com.example.cinema.dao.PlaceRepository;
import com.example.cinema.dao.SalleRepository;
import com.example.cinema.dao.VilleRepository;
import com.example.cinema.entities.Cinema;
import com.example.cinema.entities.Place;
import com.example.cinema.entities.Salle;
import com.example.cinema.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class InitCinemaImpl implements InitCinema{
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;


    @Override
    public void initVille() {
        Stream<String> villes =Stream.of("Casablanca","Rabat","Tanger","Marrakech","Kénitra");
        villes.forEach(v->{
            Ville ville=new Ville();
            ville.setName(v);
            villeRepository.save(ville);
        });

    }

    @Override
    public void initCinema() {

        List<String> Cinemas=new ArrayList<>();
        Cinemas.add("Chahrazad");
        Cinemas.add("Rif");
        Cinemas.add("Megarama");
        Cinemas.add("Andalous");
        Cinemas.add("CinemaMall");

        List<Ville> villes=villeRepository.findAll();
        villes.forEach(ville->{
            Cinemas.forEach(cinemaName->{
                Cinema cinema=new Cinema();
                cinema.setName(cinemaName);
               cinema.setVille(ville);
               cinema.setNombreSalles(7);
                cinemaRepository.save(cinema);
            });

        });


    }

    @Override
    public void initSalle() {
        cinemaRepository.findAll().forEach(cinema->{
        for(int i =0;i<cinema.getNombreSalles();i++){
            Salle salle=new Salle();
             salle.setName("Salle n°="+ i);
             salle.setNombrePlace( (int) Math.random()*71+4);
             salle.setCinema(cinema);
             salleRepository.save(salle);

        }

        });

    }

    @Override
    public void initPlace() {
        salleRepository.findAll().forEach(salle->{
            for(int i=0;i<salle.getNombrePlace();i++){
                Place place=new Place();
                place.setNumero(i);
                place.setSalle(salle);
                place.setLongitude((int) Math.random()*71+4);
                place.setLatitude((int) Math.random()*71+4);
                place.setAltitude((int) Math.random()*71+4);
                placeRepository.save(place);

            }


        });

    }

    @Override
    public void initSeance() {



    }

    @Override
    public void initCategory() {

    }

    @Override
    public void initFilm() {

    }

    @Override
    public void initProjection() {

    }

    @Override
    public void initTickets() {

    }
}
