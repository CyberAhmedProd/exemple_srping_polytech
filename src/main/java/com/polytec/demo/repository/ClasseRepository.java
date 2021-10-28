package com.polytec.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polytec.demo.entity.Classe;
import com.polytec.demo.entity.Personne;
@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	
    public Optional<Classe> getClasseByDesignation(String designation);
    public Optional<Classe> getClasseById(Long id);

}