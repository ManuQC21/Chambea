package com.chambea.services.impl;

import com.chambea.model.Freelancer;
import com.chambea.repositories.FreelancerRepository;
import com.chambea.services.FreelancerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    FreelancerRepository freelancerRepository;

    FreelancerServiceImpl(FreelancerRepository freelancerRepository){
        this.freelancerRepository = freelancerRepository;
    }

    @Override
    public Freelancer registrarFreelancer(Freelancer freelancer) {
        return freelancerRepository.save(freelancer);
    }

    @Override
    public Freelancer actualizarFreelancer(Freelancer freelancer) {
        return this.freelancerRepository.save(freelancer);
    }

    @Override
    public Freelancer obtenerPorId(Integer id) {
        return freelancerRepository.getById(id);
    }

    @Override
    public void eliminarFreelancer(Integer id) {
        this.freelancerRepository.deleteById(id);
    }

    @Override
    public List<Freelancer> listarFreelancers() {
        return this.freelancerRepository.findAll();
    }
}
