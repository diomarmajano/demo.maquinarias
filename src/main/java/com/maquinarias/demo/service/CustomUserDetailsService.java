package com.maquinarias.demo.service;

import com.maquinarias.demo.model.Usuarios;
import com.maquinarias.demo.repository.UsuariosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuariosInterface usuariosInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuariosInterface.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + username));

                String claveConPrefijo = "{noop}" + usuario.getClave();

        return new User(
                usuario.getCorreo(),
                claveConPrefijo, 
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}