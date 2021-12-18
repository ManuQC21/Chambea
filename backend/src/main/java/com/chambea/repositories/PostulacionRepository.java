package com.chambea.repositories;

import com.chambea.model.Freelancer;
import com.chambea.model.Postulacion;
import com.chambea.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {

    List<Postulacion> getByTrabajo(Trabajo trabajo);
    List<Postulacion> getByFreelancer(Freelancer freelancer);

}
