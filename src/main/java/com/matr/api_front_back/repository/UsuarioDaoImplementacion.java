package com.matr.api_front_back.repository;


import com.matr.api_front_back.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImplementacion implements UsuarioDao  {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario ";
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public void deleteUsuario(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario); //inserta objeto usuario en la bd mssql
    }

}
