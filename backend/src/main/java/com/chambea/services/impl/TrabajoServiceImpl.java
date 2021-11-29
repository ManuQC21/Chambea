package com.chambea.services.impl;

import com.chambea.model.Trabajo;
import com.chambea.repositories.TrabajoRepository;
import com.chambea.services.TrabajoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajoServiceImpl implements TrabajoService {

    TrabajoRepository trabajoRepository;

    TrabajoServiceImpl(TrabajoRepository trabajoRepository) {
        this.trabajoRepository = trabajoRepository;
    }

    @Override
    public Trabajo resgitrarTrabajo(Trabajo trabajo) {
        return trabajoRepository.save(trabajo);
    }

    @Override
    public Trabajo modificarTrabajo(Trabajo trabajo) {
        return  trabajoRepository.save(trabajo);
    }

    @Override
    public Trabajo obtenerPorId(Integer id) {
        return trabajoRepository.getById(id);
    }

    @Override
    public void eliminarTrabajo(Integer id) {
        this.trabajoRepository.deleteById(id);
    }

    @Override
    public List<Trabajo> listarTrabajos() {
        return this.trabajoRepository.findAll();
    }
}
