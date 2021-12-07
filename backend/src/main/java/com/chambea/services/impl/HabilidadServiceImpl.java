package com.chambea.services.impl;

import com.chambea.model.Categoria;
import com.chambea.model.Habilidad;
import com.chambea.repositories.HabilidadRepository;
import com.chambea.services.util.HabilidadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HabilidadServiceImpl implements HabilidadService {


    private final HabilidadRepository habilidadRepository;

    @Override
    public Habilidad createHabilidad(Habilidad habilidad) {
        return this.habilidadRepository.save(habilidad);
    }

    @Override
    public List<Habilidad> getAll() {
        return this.habilidadRepository.findAll();
    }

    @Override
    public Habilidad get(Integer id) {
        return this.habilidadRepository.getById(id);
    }

    @Override
    public Habilidad updateHabilidad(Habilidad habilidad) {
        return this.habilidadRepository.save(habilidad);
    }

    @Override
    public void deleteHabilidad(Integer id) {
        this.habilidadRepository.deleteById(id);
    }

    @Override
    public List<Habilidad> getByCategory(Categoria categoria) {
        return this.habilidadRepository.findByIdCategoria(categoria);
    }
}
