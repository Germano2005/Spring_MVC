package com.germanomvc.registroweb.repositories;


import com.germanomvc.registroweb.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> { // o JPA retona para a gente um lista que se torna mais concreta para entender

}
