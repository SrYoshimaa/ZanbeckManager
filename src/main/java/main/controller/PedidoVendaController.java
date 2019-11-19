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
import main.repository.ClienteRepository;
import main.repository.PedidoVendaRepository;
import main.repository.ItemPedidoRepository;

@Controller
@RequestMapping("/pedidovenda")
public class PedidoVendaController {
	@Autowired
	private PedidoVendaRepository pedidoVendaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<PedidoVenda> listaPedidoVenda = this.pedidoVendaRepository.findAll();
		return new ModelAndView("pedidovenda/index", "pedidovenda", listaPedidoVenda);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute PedidoVenda pedidoVenda) {
		List<Cliente> listacliente = this.clienteRepository.findAll();
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidovenda", pedidoVenda);
		dados.put("listacliente", listacliente);
		return new ModelAndView("pedidovenda/form", dados);
	}

	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") PedidoVenda pedidoVenda) {
		List<Cliente> listacliente = this.clienteRepository.findAll();
		HashMap<String, Object> dados = new HashMap<>();
		dados.put("pedidovenda", pedidoVenda);
		dados.put("listacliente", listacliente);
		return new ModelAndView("pedidovenda/form", dados);
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
		this.pedidoVendaRepository.deleteById(id);
		return new ModelAndView("redirect:/pedidovenda");
	}
	
    @PostMapping(params= {"save"})
    public ModelAndView save(@Valid PedidoVenda pedidoVenda, @Valid ItemPedido novoitempedido, BindingResult result, RedirectAttributes redirect) {
    	pedidoVenda = this.pedidoVendaRepository.save(pedidoVenda);
        return new ModelAndView("redirect:/pedidovenda");
    }
}
