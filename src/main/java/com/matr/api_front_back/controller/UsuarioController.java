package com.matr.api_front_back.controller;


import com.matr.api_front_back.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//se hace la notacion de que sera un clase de tipo controler
//de igual forma se crea en automatico el bean de esta clase
//para posteriormente el contenedor pueda gestionarla
@RestController
public class UsuarioController {

    //se comienzan a crear los endpoints con los cuales el cliente hara los requests
    @GetMapping(value = "prueba")
    public String prueba() {
        return "prueba controller";
    }

    @GetMapping(value = "json")
    public Usuario json() {
        Usuario usuario = new Usuario();
        usuario.setNombre("milton");
        usuario.setApellido("torres");
        usuario.setEmail("mil@gmail.com");
        usuario.setTelefono("72727262");
        usuario.setPassword("1234");
        return usuario;
    }

    @GetMapping(value = "usuario/{id}")
    public Usuario getusuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("milton");
        usuario.setApellido("torres");
        usuario.setEmail("mil@gmail.com");
        usuario.setTelefono("72727262");
        usuario.setPassword("1234");
        return usuario;
    }
}
