package com.chambea.services.impl;

import com.chambea.model.EstadoPropuesta;
import com.chambea.model.Freelancer;
import com.chambea.model.Postulacion;
import com.chambea.model.Trabajo;
import com.chambea.repositories.EstadoPropuestaRepository;
import com.chambea.repositories.PostulacionRepository;
import com.chambea.services.EstadoPropuestaService;
import com.chambea.services.PostulacionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PostulacionServiceImpl implements PostulacionService {

    private EstadoPropuestaRepository estadoPropuestaRepository;
    private PostulacionRepository postulacionRepository;

    @Override
    public Postulacion create(Postulacion postulacion) {
        postulacion.setFecha(LocalDate.now());
        postulacion.setEstado(this.estadoPropuestaRepository.getByDescripcion("En espera"));
        return this.postulacionRepository.save(postulacion);
    }

    @Override
    public List<Postulacion> getAll() {
        return this.postulacionRepository.findAll();
    }

    @Override
    public Postulacion get(Integer id) {
        return this.postulacionRepository.findById(id).get();
    }

    @Override
    public Postulacion update(Postulacion postulacion) {
        return this.postulacionRepository.save(postulacion);
    }

    @Override
    public void delete(Integer id) {
        this.postulacionRepository.deleteById(id);
    }

    @Override
    public List<Postulacion> getByTrabajo(Trabajo trabajo) {
        return this.postulacionRepository.getByTrabajo(trabajo);
    }

    @Override
    public List<Postulacion> getByFreelancer(Freelancer freelancer) {
        return this.postulacionRepository.getByFreelancer(freelancer);
    }
}
