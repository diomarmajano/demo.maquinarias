package com.maquinarias.demo.repository;

import org.springframework.stereotype.Repository;
import com.maquinarias.demo.model.Maquinas;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MaquinasInterface extends JpaRepository<Maquinas, Long>{

}
