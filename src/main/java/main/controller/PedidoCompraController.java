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

import main.models.Fornecedor;
import main.models.PedidoCompra;
import main.service.FornecedorService;
import main.service.PedidoCompraService;

@Controller
@RequestMapping("/pedidocompra")
public class PedidoCompraController {
	@Autowired
	private PedidoCompraService pedidoCompraService;
	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping
	public ModelAndView index() {
		List<PedidoCompra> lista = pedidoCompraService.getAll();
		return new ModelAndView("pedidocompra/index", "pedidocompra", lista);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute PedidoCompra pedidoCompra) {
		List<Fornecedor> listafornecedor = fornecedorService.getAll();
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidocompra", pedidoCompra);
		dados.put("listafornecedor", listafornecedor);
		return new ModelAndView("pedidocompra/form", dados);
	}

	@PostMapping(params = "form")
	public ModelAndView save(@Valid PedidoCompra pedidoCompra) {
		pedidoCompraService.save(pedidoCompra);
		return new ModelAndView("redirect:/pedidocompra");
	}

	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") PedidoCompra pedidoCompra) {
		List<Fornecedor> listafornecedor = fornecedorService.getAll();
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidocompra", pedidoCompra);
		dados.put("listafornecedor", listafornecedor);
		return new ModelAndView("pedidocompra/form", dados);
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") PedidoCompra pedidoCompra) {
		pedidoCompraService.delete(pedidoCompra);
		return new ModelAndView("redirect:/pedidocompra");
	}

}
