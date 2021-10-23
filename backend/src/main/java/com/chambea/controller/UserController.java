package com.chambea.controller;

import com.chambea.model.Usuario;
import com.chambea.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UsuarioService usuarioService;

    UserController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuario){
        Usuario usuarioNew = this.usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<Usuario>(usuarioNew, HttpStatus.CREATED);
    }

    @GetMapping("/iniciarsesion")
    public ResponseEntity<String> iniciarSesion(
            @RequestParam String usuario,
            @RequestParam String password){

        Optional<Usuario> usuarioLogeado = usuarioService.obtenerUsuarioPorUsuarioYContrasena(usuario, password);
        if (usuarioLogeado.isPresent()){
            return new ResponseEntity<String>("Credenciales validas", HttpStatus.OK);
        }

        return new ResponseEntity<>("Credenciales invalidas", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable("email") String email){
        Usuario usuario = this.usuarioService.obtenerUsuarioPorEmail(email);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PutMapping("/reestablecerPassword")
    public ResponseEntity<Usuario> reestablecerPassword(
            @RequestParam String email,
            @RequestParam String password
    ){
        Usuario usuario = usuarioService.modificarPassword(email,password);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
}