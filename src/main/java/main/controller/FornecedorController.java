package main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.models.Fornecedor;
import main.service.FornecedorService;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Fornecedor> lista = fornecedorService.getAll();
		return new ModelAndView("fornecedor/index", "fornecedores", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Fornecedor fornecedor) {
		return new ModelAndView("fornecedor/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Fornecedor fornecedor) {
		fornecedorService.save(fornecedor);
		return new ModelAndView("redirect:/fornecedor");
	}
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Fornecedor fornecedor) {
		return new ModelAndView("fornecedor/form", "fornecedor",fornecedor);
	}
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Fornecedor fornecedor) {
		fornecedorService.delete(fornecedor);
		return new ModelAndView("redirect:/fornecedor");
	}
}
