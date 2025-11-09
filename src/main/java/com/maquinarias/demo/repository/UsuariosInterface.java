package com.maquinarias.demo.repository;

import org.springframework.stereotype.Repository;
import com.maquinarias.demo.model.Usuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuariosInterface extends JpaRepository<Usuarios, Long>{

    Optional<Usuarios> findByCorreo(String correo);

}
