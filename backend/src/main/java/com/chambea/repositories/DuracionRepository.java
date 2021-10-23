package com.chambea.repositories;

import com.chambea.model.Duracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuracionRepository extends JpaRepository<Duracion, Integer> {
}
