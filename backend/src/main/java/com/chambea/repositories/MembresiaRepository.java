package com.chambea.repositories;

import com.chambea.model.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    Membresia getByIdMembresia(Integer idMembresia);
}
