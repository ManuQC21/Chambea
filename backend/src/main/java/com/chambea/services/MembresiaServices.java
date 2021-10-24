package com.chambea.services;

import com.chambea.model.Membresia;

import java.util.Optional;

public interface MembresiaServices {

    Membresia registrarMembresia(Membresia membresia);;
    void eliminarMembresia(Integer idMembresia);

    Optional<Membresia> obtenerMembresiaPorId(Integer id);

}