package com.chambea.services;


import com.chambea.model.Freelancer;
import com.chambea.model.Postulacion;
import com.chambea.model.Trabajo;

import java.util.List;

public interface PostulacionService {

    Postulacion create(Postulacion postulacion);
    List<Postulacion> getAll();
    Postulacion get(Integer id);
    Postulacion update(Postulacion postulacion);
    void delete(Integer id);

    List<Postulacion> getByTrabajo(Trabajo trabajo);
    List<Postulacion> getByFreelancer(Freelancer freelancer);


}
