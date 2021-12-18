package com.chambea.services;

import com.chambea.model.*;

import java.util.List;

public interface ExperienciaLaboralService {

    ExperienciaLaboral createExperienciaLaboral(ExperienciaLaboral experienciaLaboral);

    ExperienciaLaboral upadteExperienciaLaboral(ExperienciaLaboral experienciaLaboral);

    void deleteExperienciaLaboral(Integer id);

    List<ExperienciaLaboral> listByFree(Freelancer freelancer);

}
