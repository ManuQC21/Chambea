package com.chambea.services;

import com.chambea.model.EstadoPropuesta;

import java.util.List;

public interface EstadoPropuestaService {

    EstadoPropuesta createEstadoPropuesta(EstadoPropuesta estadoPropuesta);
    List<EstadoPropuesta> getAll();
    EstadoPropuesta getEstadoPropuesta(Integer id);
    EstadoPropuesta updateEstadoPropuesta(EstadoPropuesta estadoPropuesta);
    void deleteEstadoPropuesta(Integer id);
}
