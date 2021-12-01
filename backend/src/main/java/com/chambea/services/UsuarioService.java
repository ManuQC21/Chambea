package com.chambea.services;

import com.chambea.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);
    List<Usuario> getAll();
    Optional<Usuario> getUsuario(Integer id);
    Usuario updateUsuario(Usuario usuario);
    void deleteUsuario(Integer idUsuario);

    Usuario getUserByEmail(String email);
    Optional<Usuario> getUserByUsernameAndPassword(String username, String password);
    Usuario updatePassword(String email, String password);
}