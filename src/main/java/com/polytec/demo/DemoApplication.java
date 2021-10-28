package com.polytec.demo;

import com.polytec.demo.entity.Classe;
import com.polytec.demo.entity.Personne;
import com.polytec.demo.repository.ClasseRepository;
import com.polytec.demo.repository.PersonneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	PersonneRepository personneRepository;
	@Autowired
	ClasseRepository classeRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Date dateNaissance = new Date(1992-1900,11-1,22);
		Personne p1 = new Personne("samer","hassen","09331230",dateNaissance);
		Personne p2 = new Personne("mohammed","hassen",null,dateNaissance);
		Personne p3 = new Personne("salem","hassen",null,dateNaissance);
		personneRepository.save(p1);
		personneRepository.save(p2);
		personneRepository.save(p3);
		Collection<Personne> personnesWithoutCin = personneRepository.findByCinIsNull();
		Classe c1 = new Classe();
	    c1.setDesignation("La Classe");
		List<Personne> listPersonne = new ArrayList<Personne>();
		listPersonne.add(p1);
	    listPersonne.add(p2);
		listPersonne.add(p3);
		c1.setPersonnes(listPersonne);
		classeRepository.save(c1);
	   System.out.println("nombre de personnes without Cin = "+ personnesWithoutCin.size());

	   for(Personne p : personnesWithoutCin){

		   System.out.println("nom "+ p.getNom());
	   }
	   
	}
}
