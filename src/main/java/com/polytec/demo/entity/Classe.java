package com.polytec.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Classe {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    @Column(name = "designation")
    private String designation;
    @OneToMany
    private List<Personne> personnes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classe(String designation, List<Personne> personnes) {
		super();
		this.designation = designation;
		this.personnes = personnes;
	}
	
	
    
    
}
