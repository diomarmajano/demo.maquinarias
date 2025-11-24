package com.maquinarias.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.maquinarias.demo.model.Usuarios;
import com.maquinarias.demo.repository.UsuariosInterface;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    private final UsuariosInterface usuariosInterface;

    public UsuariosServiceImpl(UsuariosInterface usuariosInterface) {
        this.usuariosInterface = usuariosInterface;
    }

    @Override
    public List <Usuarios> getAllUsuarios(){
        return usuariosInterface.findAll();
    }
}