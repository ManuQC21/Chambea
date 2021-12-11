package com.chambea.controller;

import com.chambea.model.Comentario;
import com.chambea.services.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("comentario")
public class ComentarioController {

    private final ComentarioService commentService;


    public ComentarioController(ComentarioService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comentario> crearCalificacionyComentario(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(this.commentService.crearCalificacionyComentario(comentario), HttpStatus.OK);
    }
}