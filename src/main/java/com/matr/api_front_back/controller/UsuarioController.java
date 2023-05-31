package com.matr.api_front_back.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {


    @GetMapping(value = "prueba")
    public String prueba(){
        return "prueba controller";
    }
}
