package com.chambea.services;


import com.chambea.dto.UsuarioDto;
import com.chambea.model.Freelancer;

import java.util.List;

public interface FreelancerService {

    Freelancer createFreelancer(Freelancer freelancer);
    List<Freelancer> getAll();
    Freelancer getFreelancer(Integer id);
    Freelancer updateFreelancer(Freelancer freelancer);
    void deleteFreelancer(Integer id);

}
