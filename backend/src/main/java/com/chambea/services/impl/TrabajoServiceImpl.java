package com.chambea.services.impl;

import com.chambea.model.Empleador;
import com.chambea.model.RequiereHabilidad;
import com.chambea.model.Trabajo;
import com.chambea.repositories.TrabajoRepository;
import com.chambea.services.TrabajoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class TrabajoServiceImpl implements TrabajoService {

    TrabajoRepository trabajoRepository;

    TrabajoServiceImpl(TrabajoRepository trabajoRepository) {
        this.trabajoRepository = trabajoRepository;
    }

    @Transactional
    @Override
    public Trabajo createTrabajo(Trabajo trabajo) {
        log.error(trabajo.getHabilidades().toString());

        for (RequiereHabilidad habilidad : trabajo.getHabilidades()){
            habilidad.setIdTrabajo(trabajo);
            log.error("llegue");
        }
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
        return this.trabajoRepository.getByEmpleador(empleador);
    }

    @Override
    public List<Trabajo> getAll() {
        return this.trabajoRepository.findAll();
    }
}
