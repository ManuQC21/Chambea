package com.chambea.respositories;

import com.chambea.model.RequiereHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequiereHabilidadRepository extends JpaRepository<RequiereHabilidad, Integer> {
}
