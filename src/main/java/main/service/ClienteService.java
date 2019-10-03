package main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.models.Cliente;

@Service
public interface ClienteService {
	List<Cliente> getAll();
	void save(Cliente cliente);
	void delete(Cliente cliente);
}
