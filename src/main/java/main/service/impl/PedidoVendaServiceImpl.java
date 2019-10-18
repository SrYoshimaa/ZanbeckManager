package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.PedidoVenda;
import main.repository.PedidoVendaRepository;
import main.service.PedidoVendaService;

@Service
public class PedidoVendaServiceImpl implements PedidoVendaService {

	@Autowired
	private PedidoVendaRepository repository;

	@Override
	public List<PedidoVenda> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(PedidoVenda pedidoVenda) {
		repository.save(pedidoVenda);
	}

	@Override
	public void delete(PedidoVenda pedidoVenda) {
		repository.delete(pedidoVenda);
	}

}
