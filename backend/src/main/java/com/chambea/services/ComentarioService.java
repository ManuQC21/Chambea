package com.chambea.services;


import com.chambea.model.Comentario;

import java.util.*;

public interface ComentarioService {

    Comentario crearCalificacionyComentario(Comentario comment);
    void delete(Comentario comment);
    List<Comentario> getComentario();
}