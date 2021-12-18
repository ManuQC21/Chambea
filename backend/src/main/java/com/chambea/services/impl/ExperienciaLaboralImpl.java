package com.chambea.services.impl;

import com.chambea.model.ExperienciaLaboral;
import com.chambea.model.Freelancer;
import com.chambea.repositories.ExperienciaLaboralRepository;
import com.chambea.services.ExperienciaLaboralService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExperienciaLaboralImpl implements ExperienciaLaboralService {

    ExperienciaLaboralRepository experienciaLaboralRepository;


    @Override
    public ExperienciaLaboral createExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        return experienciaLaboralRepository.save(experienciaLaboral);
    }

    @Override
    public ExperienciaLaboral upadteExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        return  experienciaLaboralRepository.save(experienciaLaboral);
    }

    @Override
    public void deleteExperienciaLaboral(Integer id) {
        experienciaLaboralRepository.deleteById(id);
    }

    @Override
    public List<ExperienciaLaboral> listByFree(Freelancer freelancer) {
        return experienciaLaboralRepository.getByIdFreelancer(freelancer);
    }
}
