package com.chambea.controller;

import com.chambea.model.Usuario;
import com.chambea.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    AuthController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String usuario,
            @RequestParam String password){

        Optional<Usuario> usuarioLogeado = usuarioService.obtenerUsuarioPorUsuarioYContrasena(usuario, password);
        if (usuarioLogeado.isPresent()){
            return new ResponseEntity<String>("Credenciales validas", HttpStatus.OK);
        }
        return new ResponseEntity<>("Credenciales invalidas", HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/signin")
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario){
        Usuario usuarioNew = this.usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<Usuario>(usuarioNew, HttpStatus.CREATED);
    }

}
