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

import main.models.Cliente;
import main.models.PedidoVenda;
import main.service.ClienteService;
import main.service.PedidoVendaService;

@Controller
@RequestMapping("/pedidovenda")
public class PedidoVendaController {
	@Autowired
	private PedidoVendaService pedidoVendaService;
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ModelAndView index() {
		List<PedidoVenda> lista = pedidoVendaService.getAll();
		return new ModelAndView("pedidovenda/index", "pedidovenda", lista);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute PedidoVenda pedidoVenda) {
		List<Cliente> listacliente = clienteService.getAll();
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidovenda", pedidoVenda);
		dados.put("listacliente", listacliente);
		return new ModelAndView("pedidovenda/form", dados);
	}

	@PostMapping(params = "form")
	public ModelAndView save(@Valid PedidoVenda pedidoVenda) {
		pedidoVendaService.save(pedidoVenda);
		return new ModelAndView("redirect:/pedidovenda");
	}

	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") PedidoVenda pedidoVenda) {
		List<Cliente> listacliente = clienteService.getAll();
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidovenda", pedidoVenda);
		dados.put("listacliente", listacliente);
		return new ModelAndView("pedidovenda/form", dados);
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") PedidoVenda pedidoVenda) {
		pedidoVendaService.delete(pedidoVenda);
		return new ModelAndView("redirect:/pedidoVenda");
	}
}
