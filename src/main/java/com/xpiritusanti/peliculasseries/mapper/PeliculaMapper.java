package com.xpiritusanti.peliculasseries.mapper;

import com.xpiritusanti.peliculasseries.DTOs.PeliculasDTO;
import com.xpiritusanti.peliculasseries.Entidades.Peliculas;

public class PeliculaMapper {

    public static PeliculasDTO toDTO(Peliculas pelicula) {
        return new PeliculasDTO(
            pelicula.getId(),
            pelicula.getTitulo(),
            pelicula.getDirector(),
            pelicula.getAniolanzamiento(),
            pelicula.getGenero(),
            pelicula.getPortadaurl()
        );
    } //Convierte una entidad Peliculas a un PeliculasDTO.

    public static Peliculas toEntity(PeliculasDTO peliculaDTO) {
        Peliculas pelicula = new Peliculas();
        pelicula.setId(peliculaDTO.getId());
        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setDirector(peliculaDTO.getDirector());
        pelicula.setAniolanzamiento(peliculaDTO.getAniolanzamiento());
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setPortadaurl(peliculaDTO.getPortadaUrl());
        return pelicula;
    } //Convierte un PeliculasDTO a una entidad Peliculas.

}
