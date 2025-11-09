package com.maquinarias.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.maquinarias.demo.model.Maquinas;
import com.maquinarias.demo.repository.MaquinasInterface;

@Service
public class MaquinasServiceImpl implements MaquinasService{

    @Autowired
    private MaquinasInterface maquinasInterface;

    @Override
    public List <Maquinas> getAllMaquinas(){
        return maquinasInterface.findAll();
    }
}