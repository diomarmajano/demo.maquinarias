package com.maquinarias.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.hateoas.RepresentationModel;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "tipos_usuario")
public class Tipos_usuarios extends RepresentationModel<Tipos_usuarios>{
    @Getter @Setter 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipos_usurio;

    @Getter @Setter
    @NotNull
    @Column(name = "nombre_tipo")
    private String nombre_tipo;
}
