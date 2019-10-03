package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Long>{
	Fornecedor findByNome(String nome);
}
