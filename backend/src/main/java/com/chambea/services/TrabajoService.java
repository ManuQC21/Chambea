package com.chambea.services;

import com.chambea.model.Empleador;
import com.chambea.model.Trabajo;

import java.util.List;

public interface TrabajoService {

    Trabajo createTrabajo(Trabajo trabajo);
    List<Trabajo> getAll();
    Trabajo getTrabajo(Integer id);
    Trabajo updateTrabajo(Trabajo trabajo);
    void deleteTrabajo(Integer id);

    List<Trabajo> getByEmpleador(Empleador empleador);

}
