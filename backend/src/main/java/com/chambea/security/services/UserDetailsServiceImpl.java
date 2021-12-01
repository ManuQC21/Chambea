package com.chambea.security.services;

import com.chambea.model.Usuario;
import com.chambea.repositories.UsuarioRepository;
import com.chambea.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(s)
                .orElseThrow(()-> new UsernameNotFoundException(("Usuario no encontrado:" +s)));

        return UserDetailsImpl.build(usuario);
    }
}


