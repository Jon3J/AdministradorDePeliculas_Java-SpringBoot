package com.xpiritusanti.peliculasseries.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpiritusanti.peliculasseries.DTOs.PeliculasDTO;
import com.xpiritusanti.peliculasseries.Servicios.PeliculaServicio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "*")
public class PeliculasControlador {

    @Autowired
    private PeliculaServicio peliculaServicio;
    
    @GetMapping
    public List<PeliculasDTO> obtenerListaPeliculas() {
        return peliculaServicio.serv_obtenerListaPeliculas();
    }

    @GetMapping("/{id}")
    public PeliculasDTO buscarPeliculaPorId(@PathVariable Long id) {
        return peliculaServicio.serv_buscarPeliculaPorId(id);
    }
    
    @PostMapping
    public PeliculasDTO agregarNuevaPelicula(@RequestBody PeliculasDTO dto) {
        return peliculaServicio.serv_insertarNuevaPelicula(dto);
    }

    @PutMapping("/{id}")
    public PeliculasDTO actualizarPeliculas(@PathVariable Long id, @RequestBody PeliculasDTO dto) {
        return peliculaServicio.serv_actualizarPelicula(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarPeliculas(@PathVariable Long id) {
        peliculaServicio.serv_eliminarPeliculas(id);
    }
    
}
