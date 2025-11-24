package com.maquinarias.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.maquinarias.demo.model.Maquinas;
import com.maquinarias.demo.repository.MaquinasInterface;

@Service
public class MaquinasServiceImpl implements MaquinasService{

    private final MaquinasInterface maquinasInterface;

    public MaquinasServiceImpl(MaquinasInterface maquinasInterface) {
        this.maquinasInterface = maquinasInterface;
    }

    @Override
    public List <Maquinas> getAllMaquinas(){
        return maquinasInterface.findAll();
    }
}