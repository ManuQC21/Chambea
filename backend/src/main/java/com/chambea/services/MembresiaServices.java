package com.chambea.services;

import com.chambea.model.Membresia;

public interface MembresiaServices {

    Membresia registrarMembresia(Membresia membresia);;
    void eliminarMembresia(Integer idMembresia);

}