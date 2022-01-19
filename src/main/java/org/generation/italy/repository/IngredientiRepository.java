package org.generation.italy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.generation.italy.model.Ingrediente;

@Repository
public interface IngredientiRepository extends JpaRepository<Ingrediente, Integer> {

}
