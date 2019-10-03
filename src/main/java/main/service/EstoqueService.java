package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.models.Estoque;

@Service
public interface EstoqueService {
	List<Estoque> getAll();
	void save(Estoque estoque);
	void delete(Estoque estoque);
}
