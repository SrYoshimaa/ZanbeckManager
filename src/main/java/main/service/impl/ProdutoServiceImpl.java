package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.Produto;
import main.repository.ProdutoRepository;
import main.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public List<Produto> getAll() {
		return repository.findAll();
	}
	@Override
	public void save(Produto produto) {
		repository.save(produto);
	}
	@Override
	public void delete(Produto produto) {
		repository.delete(produto);
	}
	
	

}
