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
    public Comentario save(Comentario comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void delete(Comentario comment) {
        commentRepository.delete(comment);
    }


    @Override
    public List<Comentario> getComentario() {
        return this.commentRepository.findAll();
    }

}