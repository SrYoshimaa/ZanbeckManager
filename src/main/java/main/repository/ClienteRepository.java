package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	Cliente findByNome(String nome);
}
