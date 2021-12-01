package com.chambea.services.impl;

import com.chambea.model.Usuario;
import com.chambea.repositories.UsuarioRepository;
import com.chambea.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUserByEmail(String email) {

        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        return usuario.orElse(new Usuario());
    }

    @Override
    public Optional<Usuario> getUserByUsernameAndPassword(String username, String password) {
        return usuarioRepository.findByNombreUsuarioAndPassword(username, password);
    }

    @Override
    public Usuario updatePassword(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(new Usuario());
        usuario.setPassword(password);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Integer idUsuario) {

    }

    @Override
    public Optional<Usuario> getUsuario(Integer id) {
        return this.usuarioRepository.findById(id);
    }


}