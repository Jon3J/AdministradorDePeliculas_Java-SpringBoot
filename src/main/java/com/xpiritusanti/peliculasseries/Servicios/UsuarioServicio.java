package com.xpiritusanti.peliculasseries.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xpiritusanti.peliculasseries.Repositorios.Repo_Usuarios;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private Repo_Usuarios repoUsuarios;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException{
        var usuario = repoUsuarios.findByUsuario(nombreUsuario)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con nombre: " + nombreUsuario));

        return new User(usuario.getUsuario(), usuario.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol())));
    }

}
