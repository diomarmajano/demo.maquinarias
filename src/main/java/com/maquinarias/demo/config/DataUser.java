package com.maquinarias.demo.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.maquinarias.demo.model.Usuarios;
import com.maquinarias.demo.repository.UsuariosInterface;
import com.maquinarias.demo.model.Tipos_usuarios;

@Configuration
public class DataUser {

    @Bean
    CommandLineRunner initDatabase(
        UsuariosInterface usuariosInterface,
        PasswordEncoder passwordEncoder
    ) {
        return args -> {
                Usuarios u1 = new Usuarios();
                u1.setNombre("Diomar Majano");
                u1.setDni("257574889");
                u1.setCorreo("dmajano@gmail.com");
                u1.setTelefono("999999999");
                u1.setClave(passwordEncoder.encode("123456789"));
                u1.setTipos_usuarios(2);
                usuariosInterface.save(u1);
            
                Usuarios u2 = new Usuarios();
                u2.setNombre("Katlheen Rodriguez");
                u2.setDni("266305451");
                u2.setCorreo("krodriguez@gmail.com");
                u2.setTelefono("888888888");
                u2.setClave(passwordEncoder.encode("123456789"));
                u2.setTipoUsuario(userTipo);
                 usuariosInterface.save(u2);

                Usuarios u3 = new Usuarios();
                u3.setNombre("José Maldonado");
                u3.setDni("276395674");
                u3.setCorreo("jmaldonado@gmail.com");
                u3.setTelefono("888888888");
                u3.setClave(passwordEncoder.encode("123456789"));
                u3.setTipoUsuario(operadorTipo);
                 usuariosInterface.save(u3);
            
        };
    }
}