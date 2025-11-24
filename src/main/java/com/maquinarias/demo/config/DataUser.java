package com.maquinarias.demo.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.maquinarias.demo.model.Usuarios;
import com.maquinarias.demo.repository.UsuariosInterface;

@Configuration
public class DataUser {

    @Bean
    CommandLineRunner initDatabase(
        UsuariosInterface usuariosInterface,
        PasswordEncoder passwordEncoder
    ) {
        return args -> {
            if(!usuariosInterface.existsByCorreo("majano@gmail.com")){
                Usuarios u1 = new Usuarios();
                u1.setNombre("Diomar Majano");
                u1.setDni("257574880");
                u1.setCorreo("majano@gmail.com");
                u1.setTelefono("999999999");
                u1.setClave(passwordEncoder.encode("123456789"));
                u1.setId_tipo_usuario(2);
                usuariosInterface.save(u1);
            }
            if(!usuariosInterface.existsByCorreo("kvrodriguez@gmail.com")){
                Usuarios u2 = new Usuarios();
                u2.setNombre("Katlheen Rodriguez");
                u2.setDni("266305452");
                u2.setCorreo("kvrodriguez@gmail.com");
                u2.setTelefono("888888888");
                u2.setClave(passwordEncoder.encode("123456789"));
                u2.setId_tipo_usuario(2);
                 usuariosInterface.save(u2);
            }
            if(!usuariosInterface.existsByCorreo("jrmaldonado@gmail.com")){
                Usuarios u3 = new Usuarios();
                u3.setNombre("José Maldonado");
                u3.setDni("276395676");
                u3.setCorreo("jrmaldonado@gmail.com");
                u3.setTelefono("888888888");
                u3.setClave(passwordEncoder.encode("123456789"));
                u3.setId_tipo_usuario(2);
                 usuariosInterface.save(u3);
            }
        };
    }
}