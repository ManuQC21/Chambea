package com.chambea.services.impl;

import com.chambea.model.Empleador;
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
    public Trabajo createTrabajo(Trabajo trabajo) {
        return trabajoRepository.save(trabajo);
    }

    @Override
    public Trabajo updateTrabajo(Trabajo trabajo) {
        return  trabajoRepository.save(trabajo);
    }

    @Override
    public Trabajo getTrabajo(Integer id) {
        return trabajoRepository.getById(id);
    }

    @Override
    public void deleteTrabajo(Integer id) {
        this.trabajoRepository.deleteById(id);
    }

    @Override
    public List<Trabajo> getByEmpleador(Empleador empleador) {
        return this.trabajoRepository.getByIdEmpleador(empleador);
    }

    @Override
    public List<Trabajo> getAll() {
        return this.trabajoRepository.findAll();
    }
}
