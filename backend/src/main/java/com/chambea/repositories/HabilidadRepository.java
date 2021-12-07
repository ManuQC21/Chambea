package com.chambea.repositories;

import com.chambea.model.Categoria;
import com.chambea.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {

    List<Habilidad> findByIdCategoria(Categoria categoria);
}
