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
    public Freelancer createFreelancer(Freelancer freelancer) {
        return freelancerRepository.save(freelancer);
    }

    @Override
    public Freelancer updateFreelancer(Freelancer freelancer) {
        return this.freelancerRepository.save(freelancer);
    }

    @Override
    public Freelancer getFreelancer(Integer id) {
        return freelancerRepository.getById(id);
    }

    @Override
    public void deleteFreelancer(Integer id) {
        this.freelancerRepository.deleteById(id);
    }

    @Override
    public List<Freelancer> getAll() {
        return this.freelancerRepository.findAll();
    }
}
