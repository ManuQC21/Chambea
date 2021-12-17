package com.chambea.controller;

import com.chambea.model.Comentario;
import com.chambea.services.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ComentarioyCalificacion")
@AllArgsConstructor
public class ComentarioController {

    private final ComentarioService comentarioService;


    @GetMapping
    public ResponseEntity<List<Comentario>> getAll(){
        return new ResponseEntity<List<Comentario>>(this.comentarioService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comentario> createCalificationAndComentario(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(this.comentarioService.createComentario(comentario), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Comentario> UpdateCalificationAndComentario(@RequestBody Comentario comentario){
        return new ResponseEntity<>(this.comentarioService.UpdateCalificationAndComentario(comentario),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Comentario> deleteCalificationAndComentario(@RequestParam Integer id){
        this.comentarioService.deleteCalificationAndComentario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}