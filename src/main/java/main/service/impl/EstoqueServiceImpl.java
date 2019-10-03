package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.Estoque;
import main.repository.EstoqueRepository;
import main.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService{
	
	@Autowired
	private EstoqueRepository repository;
	
	@Override
	public List<Estoque> getAll() {
		return repository.findAll();
	}
	@Override
	public void save(Estoque estoque) {
		repository.save(estoque);
	}
	@Override
	public void delete(Estoque estoque) {
		repository.delete(estoque);
	}
	

}
