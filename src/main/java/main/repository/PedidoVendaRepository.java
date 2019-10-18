package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.PedidoVenda;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {
	PedidoVenda findById(String id);

}
