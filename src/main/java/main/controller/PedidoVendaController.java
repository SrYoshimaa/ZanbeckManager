package main.controller;

import java.util.HashMap;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import main.models.Cliente;
import main.models.ItemPedido;
import main.models.PedidoVenda;
import main.models.PedidoVendaRealizado;
import main.service.ClienteService;
import main.service.ItemPedidoService;
import main.service.PedidoVendaService;

@Controller
@RequestMapping("/pedidovenda")
public class PedidoVendaController {
	@Autowired
	private PedidoVendaService pedidoVendaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@GetMapping
	public ModelAndView index() {
		List<PedidoVenda> lista = pedidoVendaService.getAll();
		return new ModelAndView("pedidovenda/index", "pedidovenda", lista);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute PedidoVenda pedidovenda) {
		List<Cliente> listaCliente = clienteService.getAll();
		List<ItemPedido> listaItemPedido = itemPedidoService.getAll();
		
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidovenda", pedidovenda);
		dados.put("listaCliente", listaCliente);
		dados.put("listaItemPedido", listaItemPedido);
		dados.put("novopedidovenda", new PedidoVendaRealizado());
		return new ModelAndView("pedidovenda/form", dados);
	}

	@PostMapping(params = "form")
	public ModelAndView save(@Valid PedidoVenda pedidovenda, @Valid PedidoVendaRealizado novopedidovenda, BindingResult result, RedirectAttributes redirect) {
		pedidoVendaService.save(pedidovenda);
		return new ModelAndView("redirect:/pedidovenda");
	}

	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") PedidoVenda pedidovenda) {
		List<Cliente> listaCliente = clienteService.getAll();
		List<ItemPedido> listaItemPedido = itemPedidoService.getAll();
		
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidoVenda", pedidovenda);
		dados.put("listaCliente", listaCliente);
		dados.put("listaItemPedido", listaItemPedido);
		dados.put("novopedidovenda", new PedidoVendaRealizado());
		return new ModelAndView("pedidovenda/form", dados);
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") PedidoVenda pedidovenda, RedirectAttributes redirect) {
		pedidoVendaService.delete(pedidovenda);
		return new ModelAndView("redirect:/pedidovenda");
	}
	
	@PostMapping(params= {"insertproc"})
	public ModelAndView insertproc(PedidoVenda pedidovenda, PedidoVendaRealizado novopedidovenda, BindingResult result, RedirectAttributes redirect) {
		List<Cliente> listaCliente = clienteService.getAll();
		List<ItemPedido> listaItemPedido = itemPedidoService.getAll();
	
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidoVenda", pedidovenda);
		dados.put("listaCliente", listaCliente);
		dados.put("listaItemPedido", listaItemPedido);
		dados.put("novopedidovenda", new PedidoVendaRealizado());
		return new ModelAndView("pedidovenda/form", dados);
	}

}
