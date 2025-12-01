package com.xpiritusanti.peliculasseries.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "peliculas") //Con ello, le decimos a Spring que esta clase va a representar la tabla "peliculas" en la base de datos.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Peliculas { //Va a representar la tabla en la base de datos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo") //Atributos que se van a mapear con las columnas de la tabla.
    private String titulo;

    @Column(name = "director")
    private String director;

    @Column(name = "aniolanzamiento")
    private int aniolanzamiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "portadaurl")
    private String portadaurl;

    @Override
    public String toString() {
        return "Peliculas [id=" + id + ", titulo=" + titulo + ", director=" + director + ", aniolanzamiento="
                + aniolanzamiento + ", genero=" + genero + " , portadaurl=" + portadaurl + "]";
    } 
}
