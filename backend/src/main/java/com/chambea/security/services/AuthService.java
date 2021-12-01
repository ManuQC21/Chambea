package com.chambea.security.services;

import com.chambea.dto.CreateUserRequest;
import com.chambea.model.Usuario;
import com.chambea.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class AuthService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario createUsuario(CreateUserRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()){
            throw new ValidationException("Ya existe un usuario registrado con ese email");
        }

        if (usuarioRepository.findByNombreUsuario(request.getUsername()).isPresent()){
            throw new ValidationException("Ya existe un usuario registrado con ese nombre de usuario");
        }

        if(!request.getPassword().equals(request.getRePassword())){
            throw new ValidationException("Las contraseñas no coinciden");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setNombreUsuario(request.getUsername());
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());

        return this.usuarioRepository.save(usuario);
    }



}
