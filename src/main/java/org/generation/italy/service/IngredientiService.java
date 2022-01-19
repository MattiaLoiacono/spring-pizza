package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Ingrediente;
import org.generation.italy.repository.IngredientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IngredientiService {
	
	@Autowired
	private IngredientiRepository repository;
	
	public List<Ingrediente> findAllSortName(){
		return repository.findAll(Sort.by("name"));
	}
	
	public Ingrediente save(Ingrediente ingrediente) {
		return repository.save(ingrediente);
	}

	public Ingrediente getById(Integer id) {
		return repository.getById(id);
		
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
