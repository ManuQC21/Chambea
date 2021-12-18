package com.chambea.repositories;

import com.chambea.model.EstadoPropuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPropuestaRepository extends JpaRepository<EstadoPropuesta,Integer> {

    EstadoPropuesta getByDescripcion(String descripcion);
}
