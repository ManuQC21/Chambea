package com.chambea.controller;

import com.chambea.model.Usuario;
import com.chambea.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(this.usuarioService.createUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<List<Usuario>>(this.usuarioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id){
        Usuario usuario = this.usuarioService.getUsuario(id).get();
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(this.usuarioService.updateUsuario(usuario), HttpStatus.OK);
    }



    @GetMapping("/byEmail/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable("email") String email){
        Usuario usuario = this.usuarioService.getUserByEmail(email);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }


    @PutMapping("/reestablecerPassword")
    public ResponseEntity<Usuario> reestablecerPassword(
            @RequestParam String email,
            @RequestParam String password
    ){
        Usuario usuario = usuarioService.updatePassword(email,password);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
}