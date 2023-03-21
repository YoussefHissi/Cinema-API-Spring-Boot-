package com.example.cinema;

import com.example.cinema.init.InitCinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication  implements CommandLineRunner {
	@Autowired
    private InitCinema initCinema;
	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
		 System.out.println("welcome back");
	}


	@Override
	public void run(String... args) throws Exception {
		initCinema.initVille();
          initCinema.initCinema();
		  initCinema.initSalle();
		  initCinema.initPlace();
		  initCinema.initSeance();
		  initCinema.initCategory();
		  initCinema.initFilm();
		  initCinema.initProjection();
		  initCinema.initTickets();

	}
}
