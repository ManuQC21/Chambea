package com.chambea.dto;

import com.chambea.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Integer id;
    private Integer idFreelancer;
    private String username;
    private String nombres;
    private String apellidos;
    private String email;
    private boolean esFreelancer;

    public static UsuarioDto build(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId(usuario.getIdUsuario());
        usuarioDto.setUsername(usuario.getNombreUsuario());
        usuarioDto.setNombres(usuario.getNombres());
        usuarioDto.setApellidos(usuario.getApellidos());
        usuarioDto.setEmail(usuario.getEmail());
        if(usuario.getFreelancer()==null){
            usuarioDto.setEsFreelancer(false);
            return usuarioDto;
        }
        usuarioDto.setEsFreelancer(true);
        usuarioDto.setIdFreelancer(usuario.getFreelancer().getIdFreelancer());

        return usuarioDto;

    }
}
