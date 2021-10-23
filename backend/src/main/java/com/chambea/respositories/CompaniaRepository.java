package com.chambea.respositories;

import com.chambea.model.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Integer> {
}
