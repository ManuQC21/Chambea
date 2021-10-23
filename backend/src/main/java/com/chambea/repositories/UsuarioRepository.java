package com.chambea.repositories;

import com.chambea.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario getByEmail(String email);
    Optional<Usuario> findByNombreUsuario(String username);
    Optional<Usuario> findByNombreUsuarioAndPassword(String username, String password);
}
