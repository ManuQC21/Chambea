package com.chambea.services.impl;

import com.chambea.model.Comentario;
import com.chambea.repositories.ComentarioRepository;
import com.chambea.services.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Override
    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public List<Comentario> getAll() {
        return this.comentarioRepository.findAll();}

    @Override
    public Comentario UpdateCalificationAndComentario(Comentario comentario) {

        Comentario comentario1 = this.comentarioRepository.save(comentario);
        return comentario1;
    }
    @Override
    public void deleteCalificationAndComentario(Integer id) {
        this.comentarioRepository.deleteById(id);
    }

}
