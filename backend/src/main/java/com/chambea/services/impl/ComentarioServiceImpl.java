package com.chambea.services.impl;


import com.chambea.model.Comentario;
import com.chambea.repositories.ComentarioRepository;
import com.chambea.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository commentRepository;

    @Autowired
    public ComentarioServiceImpl(ComentarioRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comentario crearCalificacionyComentario(Comentario comment) {
        return commentRepository.save(comment);
    }

    public List<Comentario> getAll() {
        return this.commentRepository.findAll();
    }

    public Comentario save(Comentario comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void delete(Comentario comment) {
        commentRepository.delete(comment);
    }


    public List<Comentario> getComentario() {
        return this.commentRepository.findAll();
    }

}