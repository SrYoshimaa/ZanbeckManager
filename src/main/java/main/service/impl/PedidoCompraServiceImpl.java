package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.PedidoCompra;
import main.repository.PedidoCompraRepository;
import main.service.PedidoCompraService;

@Service
public class PedidoCompraServiceImpl implements PedidoCompraService {

	@Autowired
	private PedidoCompraRepository repository;

	@Override
	public List<PedidoCompra> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(PedidoCompra pedidoCompra) {
		repository.save(pedidoCompra);
	}

	@Override
	public void delete(PedidoCompra pedidoCompra) {
		repository.delete(pedidoCompra);
	}

}
