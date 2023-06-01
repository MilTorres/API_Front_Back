package com.matr.api_front_back.repository;

import com.matr.api_front_back.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioDao  {

    List<Usuario> getUsuarios();


    void deleteUsuario(Long id);

}
