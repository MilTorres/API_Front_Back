package com.matr.api_front_back.controller;


import com.matr.api_front_back.models.Usuario;
import com.matr.api_front_back.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//se hace la notacion de que sera un clase de tipo controler
//de igual forma se crea en automatico el bean de esta clase
//para posteriormente el contenedor pueda gestionarla
@RestController
public class UsuarioController {


    @Autowired
    private UsuarioDao usuarioDao;

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

    @GetMapping(value = "listausuario")
    public List<Usuario> getListusuario() {

        List<Usuario> listausuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("milton");
        usuario.setApellido("torres");
        usuario.setEmail("mil@gmail.com");
        usuario.setTelefono("72727262");
        usuario.setPassword("1234");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombre("gala");
        usuario2.setApellido("romero");
        usuario2.setEmail("gala@gmail.com");
        usuario2.setTelefono("4222323");
        usuario2.setPassword("1432232");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3L);
        usuario3.setNombre("mak");
        usuario3.setApellido("romero");
        usuario3.setEmail("mak@gmail.com");
        usuario3.setTelefono("92826222");
        usuario3.setPassword("11111");

        listausuarios.add(usuario);
        listausuarios.add(usuario2);
        listausuarios.add(usuario3);
        return listausuarios;
    }


    @GetMapping(value = "api/usuario")
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }




    @DeleteMapping(value = "api/usuario/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        usuarioDao.deleteUsuario(id);
    }

}
