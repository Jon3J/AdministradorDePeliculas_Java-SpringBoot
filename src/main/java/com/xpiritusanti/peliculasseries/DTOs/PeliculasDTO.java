package com.xpiritusanti.peliculasseries.DTOs;

public class PeliculasDTO {

    private Long id;
    private String titulo;
    private String director;
    private int aniolanzamiento;
    private String genero;

    private String portadaurl;

    //Constructor
    public PeliculasDTO(Long id, String titulo, String director, int aniolanzamiento, String genero, String portadaurl) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.aniolanzamiento = aniolanzamiento;
        this.genero = genero;
        this.portadaurl = portadaurl;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getAniolanzamiento() {
        return aniolanzamiento;
    }
    public void setAniolanzamiento(int aniolanzamiento) {
        this.aniolanzamiento = aniolanzamiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getPortadaUrl() {
        return portadaurl;
    }
    public void setPortadaUrl(String portadaUrl) {
        this.portadaurl = portadaUrl;
    }

    @Override
    public String toString() {
        return "PeliculasDTO [id=" + id + ", titulo=" + titulo + ", director=" + director + ", aniolanzamiento="
                + aniolanzamiento + ", genero=" + genero + " , portadaurl=" + portadaurl + "]";
    } //Esto se va a visualizar por consola. (Ayuda a depurar.)
}
