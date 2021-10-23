package com.chambea.security.services;

import com.chambea.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class UserDetailsImpl implements UserDetails {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    UserDetailsImpl(Integer id, String email, String username, String password){
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public static UserDetailsImpl build(Usuario usuario){
        return new UserDetailsImpl(
                usuario.getIdUsuario(),
                usuario.getEmail(),
                usuario.getNombreUsuario(),
                usuario.getPassword()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
