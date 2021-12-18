package com.chambea.repositories;

import com.chambea.model.Educacion;
import com.chambea.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {

}
