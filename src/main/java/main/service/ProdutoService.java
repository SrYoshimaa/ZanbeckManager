package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.models.Produto;

@Service
public interface ProdutoService {
	List<Produto> getAll();
	void save(Produto produto);
	void delete(Produto produto);

}
