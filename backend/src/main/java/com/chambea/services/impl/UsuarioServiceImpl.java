package com.chambea.services.impl;

import com.chambea.model.Empleador;
import com.chambea.model.Usuario;
import com.chambea.repositories.EmpleadorRepository;
import com.chambea.repositories.UsuarioRepository;
import com.chambea.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmpleadorRepository empleadorRepository;



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

        Usuario usuario1 = this.usuarioRepository.save(usuario);

        Empleador empleador =  new Empleador();
        empleador.setUsuario(usuario);
        empleador.setFechaRegistro(Calendar.getInstance());
        this.empleadorRepository.save(empleador);

        return usuario1;
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