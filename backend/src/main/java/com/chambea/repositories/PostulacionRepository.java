package com.chambea.repositories;

import com.chambea.model.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
}
