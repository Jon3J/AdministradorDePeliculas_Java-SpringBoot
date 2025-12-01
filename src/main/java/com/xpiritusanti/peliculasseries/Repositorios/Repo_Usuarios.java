package com.xpiritusanti.peliculasseries.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xpiritusanti.peliculasseries.Entidades.Usuario;

public interface Repo_Usuarios extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
}
