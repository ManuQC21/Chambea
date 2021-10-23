package com.chambea.services.impl;

import com.chambea.model.Usuario;
import com.chambea.repositories.UsuarioRepository;
import com.chambea.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.getByEmail(email);
    }

    @Override
    public Optional<Usuario>  obtenerUsuarioPorUsuarioYContrasena(String username, String password) {
        return usuarioRepository.findByNombreUsuarioAndPassword(username, password);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {

    }


}
