package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.ItemPedido;
import main.repository.ItemPedidoRepository;
import main.service.ItemPedidoService;

@Service
public class ItemPedidoImpl implements ItemPedidoService{

	@Autowired
	private ItemPedidoRepository repository;
	
	@Override
	public List<ItemPedido> getAll() {
		return repository.findAll();
	}
	@Override
	public void save(ItemPedido itemPedido) {
		repository.save(itemPedido);
	}
	@Override
	public void delete(ItemPedido itemPedido) {
		repository.delete(itemPedido);
	}

}
