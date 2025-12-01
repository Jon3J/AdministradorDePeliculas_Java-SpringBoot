package com.xpiritusanti.peliculasseries.Servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpiritusanti.peliculasseries.DTOs.PeliculasDTO;
import com.xpiritusanti.peliculasseries.Entidades.Peliculas;
import com.xpiritusanti.peliculasseries.Repositorios.Repo_Peliculas;
import com.xpiritusanti.peliculasseries.mapper.PeliculaMapper;

@Service
public class PeliculaServicio {

    @Autowired
    private Repo_Peliculas repoPeliculas;

    public List<PeliculasDTO> serv_obtenerListaPeliculas(){
        return repoPeliculas.findAll().stream().map(PeliculaMapper::toDTO).collect(Collectors.toList());
    }

    public PeliculasDTO serv_buscarPeliculaPorId(Long id){
        Optional<Peliculas> pelicula = repoPeliculas.findById(id);
        if(pelicula.isPresent()){
            return PeliculaMapper.toDTO(pelicula.get());
        } else {
            throw new RuntimeException("Pelicula no encontrada con id: " + id); // O lanzar una excepción si la película no existe
        }
    }

    public PeliculasDTO serv_insertarNuevaPelicula(PeliculasDTO dto){
        Peliculas pelicula = PeliculaMapper.toEntity(dto);
        Peliculas peliculaGuardada = repoPeliculas.save(pelicula);
        return PeliculaMapper.toDTO(peliculaGuardada);
    }

    public PeliculasDTO serv_actualizarPelicula(Long id, PeliculasDTO dto){
        Optional<Peliculas> peliculaExistente = repoPeliculas.findById(id);

        if(peliculaExistente.isPresent()){
            Peliculas pelicula = peliculaExistente.get();
            pelicula.setTitulo(dto.getTitulo());
            pelicula.setDirector(dto.getDirector());
            pelicula.setAniolanzamiento(dto.getAniolanzamiento());
            pelicula.setGenero(dto.getGenero());
            pelicula.setPortadaurl(dto.getPortadaUrl());

            Peliculas peliculaActualizada = repoPeliculas.save(pelicula);
            return PeliculaMapper.toDTO(peliculaActualizada);
        } else {
            throw new RuntimeException("Pelicula no encontrada con id: " + id); // O lanzar una excepción si la película no existe
        }  
        
    }

    public String serv_eliminarPeliculas(Long id){
        if(repoPeliculas.existsById(id)){
            repoPeliculas.deleteById(id);
            return "La película con ID " + id + " ha sido eliminada correctamente.";
        } else {
            return "La película con ID " + id + " no existe.";
        }
    }
}
