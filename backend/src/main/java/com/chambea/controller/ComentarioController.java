package com.chambea.controller;

import com.chambea.model.Comentario;
import com.chambea.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@SessionAttributes("comment")
public class ComentarioController {

    private final ComentarioService commentService;

    @Autowired
    public ComentarioController(ComentarioService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseEntity<List<Comentario>> getComentario() {
        List<Comentario> comments = this.commentService.getComentario();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}