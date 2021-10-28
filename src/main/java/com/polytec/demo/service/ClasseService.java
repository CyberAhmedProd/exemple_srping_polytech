package com.polytec.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytec.demo.entity.Classe;
import com.polytec.demo.entity.Personne;
import com.polytec.demo.repository.ClasseRepository;
@Service
public class ClasseService {

	@Autowired
	ClasseRepository classeRepository;
	
	public boolean Add(Classe classe)
	{	
		Optional<Classe> resultOp = classeRepository.getClasseByDesignation(classe.getDesignation());
		if(resultOp.isPresent())
			return false;
		else {
			classeRepository.save(classe);
			return true;
		}
	}
	
	public boolean update(Classe classe)
	{
		Optional<Classe> resultOp = classeRepository.getClasseById(classe.getId());
		if(resultOp.isPresent())
		{
			classeRepository.save(classe);
			return true;
		}
		else
			return false;
	}
	
	public boolean delete(Classe classe)
	{
		Optional<Classe> resultOp = classeRepository.getClasseById(classe.getId());
		if(!resultOp.isPresent())
			return false;
		else
		{
			classeRepository.delete(classe);
			return true;
		}
			
	}
	public List<Classe> getAll()
	{
		return classeRepository.findAll();
	}
}