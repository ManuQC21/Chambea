package com.chambea.services;

import com.chambea.model.Trabajo;

import java.util.List;

public interface TrabajoService {

    Trabajo resgitrarTrabajo(Trabajo trabajo);
    Trabajo modificarTrabajo(Trabajo trabajo);
    Trabajo obtenerPorId(Integer id);
    void eliminarTrabajo(Integer id);
    List<Trabajo> listarTrabajos();
}
