package com.matr.api_front_back.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//se hace la notacion de que sera un clase de tipo controler
//de igual forma se crea en automatico el bean de esta clase
//para posteriormente el contenedor pueda gestionarla
@RestController
public class UsuarioController {

//se comienzan a crear los endpoints con los cuales el cliente hara los requests
    @GetMapping(value = "prueba")
    public String prueba(){
        return "prueba controller";
    }
}
