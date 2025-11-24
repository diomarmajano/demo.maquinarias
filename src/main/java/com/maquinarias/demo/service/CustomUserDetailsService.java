package com.maquinarias.demo.service;

import com.maquinarias.demo.model.Usuarios;
import com.maquinarias.demo.repository.UsuariosInterface;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuariosInterface usuariosInterface;

    public CustomUserDetailsService(UsuariosInterface usuariosInterface) {
        this.usuariosInterface = usuariosInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuariosInterface.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + username));

       return User.builder()
                .username(usuario.getCorreo()) 
                .password(usuario.getClave())
                .build();
    }
}