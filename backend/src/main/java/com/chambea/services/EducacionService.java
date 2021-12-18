package com.chambea.services;

import com.chambea.model.Educacion;
import com.chambea.model.Freelancer;

import java.util.List;

public interface EducacionService {

    Educacion createEducacion(Educacion educacion);
    List<Educacion> getAll();
    Educacion updateEducacion(Educacion educacion);
    void deleteEducacion(Integer id);
}
