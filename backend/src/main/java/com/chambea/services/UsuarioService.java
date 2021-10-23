package com.chambea.services;

import com.chambea.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario);
    Usuario modificarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorEmail(String email);
    Optional<Usuario> obtenerUsuarioPorUsuarioYContrasena(String username, String password);
    void eliminarUsuario(Integer idUsuario);
}
