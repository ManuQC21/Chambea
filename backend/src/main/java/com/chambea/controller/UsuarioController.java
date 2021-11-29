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
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }



    @GetMapping("/byEmail/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable("email") String email){
        Usuario usuario = this.usuarioService.obtenerUsuarioPorEmail(email);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id){
        Usuario usuario = this.usuarioService.obtenerUsuarioPorId(id).get();
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