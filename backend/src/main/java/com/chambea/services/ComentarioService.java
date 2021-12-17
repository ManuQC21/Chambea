package com.chambea.services;

import com.chambea.model.Comentario;

import java.util.List;

public interface ComentarioService {
    Comentario createComentario(Comentario comentario);
    List<Comentario> getAll();
    Comentario UpdateCalificationAndComentario(Comentario comentario);
    void deleteCalificationAndComentario(Integer id);
}
