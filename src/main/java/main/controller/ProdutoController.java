package main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import main.models.Produto;
import main.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Produto> lista = produtoService.getAll();
		return new ModelAndView("produto/index", "produtos", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Produto produto) {
		return new ModelAndView("produto/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Produto produto, BindingResult result) 
	{
		if(result.hasErrors()) {
			return new ModelAndView("produto/form");
		}
		produtoService.save(produto);
		return new ModelAndView("redirect:/produto");
	}
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Produto produto) {
		return new ModelAndView("produto/form", "produto",produto);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Produto produto) {
		produtoService.delete(produto);
		return new ModelAndView("redirect:/produto");
	}
}
