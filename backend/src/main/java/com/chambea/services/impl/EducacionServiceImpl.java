package com.chambea.services.impl;

import com.chambea.model.Educacion;
import com.chambea.repositories.EducacionRepository;
import com.chambea.repositories.FreelancerRepository;
import com.chambea.services.EducacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EducacionServiceImpl implements EducacionService {
    EducacionRepository educacionRepository;
    FreelancerRepository freelancerRepository;

    @Override
    public Educacion createEducacion(Educacion educacion){
        return educacionRepository.save(educacion);
    }

    @Override
    public List<Educacion> getAll(){
        return this.educacionRepository.findAll();
    }

    @Override
    public Educacion updateEducacion(Educacion educacion){
        Educacion educacionFromBd = this.educacionRepository.findById(educacion.getIdEducacion()).get();
        educacionFromBd.setCentroEstudios(educacion.getCentroEstudios());
        educacionFromBd.setTitulo(educacion.getTitulo());
        educacionFromBd.setFechaInicio(educacion.getFechaInicio());
        educacionFromBd.setFechaFin(educacion.getFechaFin());

        return educacionRepository.save(educacionFromBd);
    }

    @Override
    public void deleteEducacion(Integer id){
        this.educacionRepository.deleteById(id);
    }
}
