package com.maquinarias.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.hateoas.RepresentationModel;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "usuarios")
public class Usuarios extends RepresentationModel<Usuarios>{
    @Getter @Setter 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Getter @Setter
    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Getter @Setter
    @NotNull
    @Column(name = "dni")
    private String dni;

    @Getter @Setter
    @NotNull
    @Column(name = "correo")
    private String correo;

    @Getter @Setter
    @NotNull
    @Column(name = "telefono")
    private String telefono;

    @Getter @Setter
    @NotNull
    @Column(name = "clave")
    private String clave;

    @ManyToOne
    @JoinColumn(name = "id_tipos_usuario")
    private Tipos_usuarios tipoUsuario;

   
}
