package com.xpiritusanti.peliculasseries;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xpiritusanti.peliculasseries.Entidades.Peliculas;
import com.xpiritusanti.peliculasseries.Repositorios.Repo_Peliculas;

@SpringBootApplication
public class PeliculasseriesApplication implements CommandLineRunner{

	@Autowired
	private Repo_Peliculas reposi;

	public static void main(String[] args) {
		SpringApplication.run(PeliculasseriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Aplicación iniciada correctamente.");
		List<Peliculas> listaPeliculas = reposi.findAll();
		listaPeliculas.stream().forEach(System.out::println);

	}
}
