package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.models.PedidoVenda;

@Service
public interface PedidoVendaService {
	List<PedidoVenda> getAll();

	void save(PedidoVenda pedidoVenda);

	void delete(PedidoVenda pedidoVenda);
}
