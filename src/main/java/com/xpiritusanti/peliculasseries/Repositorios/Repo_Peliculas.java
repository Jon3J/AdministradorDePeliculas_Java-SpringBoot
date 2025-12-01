package com.xpiritusanti.peliculasseries.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xpiritusanti.peliculasseries.Entidades.Peliculas;

public interface Repo_Peliculas extends JpaRepository<Peliculas, Long> { 
    //Va a ser nuestro repositorio de la tabla Peliculas.
    //Va a ser el que se comunique con la base de datos.
}
