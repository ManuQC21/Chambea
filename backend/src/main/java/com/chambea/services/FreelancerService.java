package com.chambea.services;


import com.chambea.model.Freelancer;

import java.util.List;

public interface FreelancerService {

    Freelancer registrarFreelancer(Freelancer freelancer);
    Freelancer obtenerPorId(Integer id);
    List<Freelancer> listarFreelancers();
}
