package com.maquinarias.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.hateoas.RepresentationModel;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "maquinas")
public class Maquinas extends RepresentationModel<Maquinas>{
    @Getter @Setter 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_maquina;

    @Getter @Setter
    @NotNull
    @Column(name = "nombre_maquina")
    private String nombre_maquina;

    @Getter @Setter
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Getter @Setter
    @NotNull
    @Column(name = "tipo_maquina")
    private String tipo_maquina;

    @Getter @Setter
    @NotNull
    @Column(name = "imagen")
    private String imagen;

    @Getter @Setter
    @NotNull
    @Column(name = "precio_por_dia")
    private double precio_por_dia;

    @Getter @Setter
    @NotNull
    @Column(name = "disponible")
    private char disponible;

    @Getter @Setter
    @NotNull
    @Column(name = "id_dueno")
    private int id_dueno;

    @Getter @Setter
    @NotNull
    @Column(name = "ubicacion")
    private String ubicacion;
}
