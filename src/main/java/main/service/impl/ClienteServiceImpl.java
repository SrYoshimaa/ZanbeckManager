package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.Cliente;
import main.repository.ClienteRepository;
import main.service.ClienteService;



@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> getAll() {
		return repository.findAll();
	}
	@Override
	public void save(Cliente cliente) {
		repository.save(cliente);
	}
	@Override
	public void delete(Cliente cliente) {
		repository.delete(cliente);
	}

}
