package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.models.ItemPedido;

@Service
public interface ItemPedidoService {
	List<ItemPedido> getAll();
	void save(ItemPedido itemPedido);
	void delete(ItemPedido itemPedido);
}
