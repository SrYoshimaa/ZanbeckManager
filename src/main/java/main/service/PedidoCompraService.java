package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.models.PedidoCompra;

@Service
public interface PedidoCompraService {
	List<PedidoCompra> getAll();

	void save(PedidoCompra pedidoCompra);

	void delete(PedidoCompra pedidoCompra);
}
