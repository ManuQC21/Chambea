package com.chambea.repositories;

import com.chambea.model.Empleador;
import com.chambea.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {

    List<Trabajo> getByEmpleador(Empleador empleador);
}
