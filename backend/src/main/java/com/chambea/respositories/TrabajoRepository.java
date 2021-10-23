package com.chambea.respositories;

import com.chambea.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
}
