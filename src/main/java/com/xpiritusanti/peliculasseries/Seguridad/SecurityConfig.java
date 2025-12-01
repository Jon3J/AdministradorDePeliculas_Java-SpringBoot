package com.xpiritusanti.peliculasseries.Seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.xpiritusanti.peliculasseries.Servicios.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final UsuarioServicio userService;

    public SecurityConfig(UsuarioServicio userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder codificaPass(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager autenticacion(AuthenticationConfiguration authConfig)
        throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityChain(HttpSecurity http, AuthenticationManager authManager)
            throws Exception{
             http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/**").permitAll()
                    .requestMatchers("/api/peliculas/**").hasAnyRole("ADMIN","USER")
                    .anyRequest().authenticated()).authenticationManager(authManager)
                    .userDetailsService(userService).formLogin(form -> form.permitAll())
                    .httpBasic(basic -> {});

                    return http.build();
    }


}
