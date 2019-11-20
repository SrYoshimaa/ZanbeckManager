package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
	ItemPedido findById(String id);

}
