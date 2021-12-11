package com.chambea.services;


import com.chambea.model.Comentario;

import java.util.List;

public interface ComentarioService {

    Comentario save(Comentario comment);
    void delete(Comentario comment);
    List<Comentario> getComentario();
}