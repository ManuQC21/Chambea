package com.chambea.repositories;

import com.chambea.model.ExperienciaLaboral;
import com.chambea.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer> {

    List<ExperienciaLaboral> getByIdFreelancer(Freelancer freelancer);
}
