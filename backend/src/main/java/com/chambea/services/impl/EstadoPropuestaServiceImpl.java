package com.chambea.services.impl;

import com.chambea.model.EstadoPropuesta;
import com.chambea.repositories.EstadoPropuestaRepository;
import com.chambea.services.EstadoPropuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadoPropuestaServiceImpl implements EstadoPropuestaService {

    private EstadoPropuestaRepository estadoPropuestaRepository;

    @Override
    public EstadoPropuesta createEstadoPropuesta(EstadoPropuesta estadoPropuesta) {
        return this.estadoPropuestaRepository.save(estadoPropuesta);
    }

    @Override
    public List<EstadoPropuesta> getAll() {
        return this.estadoPropuestaRepository.findAll();
    }

    @Override
    public EstadoPropuesta getEstadoPropuesta(Integer id) {
        return this.estadoPropuestaRepository.getById(id);
    }

    @Override
    public EstadoPropuesta updateEstadoPropuesta(EstadoPropuesta estadoPropuesta) {
        return this.estadoPropuestaRepository.save(estadoPropuesta);
    }

    @Override
    public void deleteEstadoPropuesta(Integer id) {
        this.estadoPropuestaRepository.deleteById(id);
    }
}
