package com.chambea.repositories;

import com.chambea.model.TieneHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieneHabilidadRepository extends JpaRepository<TieneHabilidad, Integer> {
}
