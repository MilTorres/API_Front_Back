package com.matr.api_front_back.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "contrasena")
    private String password;


}
