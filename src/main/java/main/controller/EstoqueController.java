package main.controller;

import java.util.HashMap;
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

import main.models.Estoque;
import main.models.Produto;
import main.repository.ProdutoRepository;
import main.service.EstoqueService;


@Controller
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
    private ProdutoRepository produtoRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Estoque> lista = estoqueService.getAll();
		return new ModelAndView("estoque/index", "estoque", lista);
	}
	@GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Estoque estoque) {
        List<Produto> listaProdutos = produtoRepository.findAll();
        return new ModelAndView("estoque/form","listaprodutos",listaProdutos);
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Estoque estoque) {
		estoqueService.save(estoque);
		return new ModelAndView("redirect:/estoque");
	}
	
	@GetMapping(value="/edit/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Estoque estoque) {
        List<Produto> listaProdutos = produtoRepository.findAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("estoque",estoque);
        dados.put("listaprodutos",listaProdutos);
        return new ModelAndView("estoque/form",dados);
	}
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Estoque estoque) {
		estoqueService.delete(estoque);
		return new ModelAndView("redirect:/estoque");
	}
}