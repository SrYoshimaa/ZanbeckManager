package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.Estoque;
	
public interface EstoqueRepository extends JpaRepository<Estoque,Long>{
	Estoque findById(long id);
}
