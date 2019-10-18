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
import main.models.PedidoVenda;
import main.service.PedidoVendaService;

@Controller
@RequestMapping("/pedidovenda")
public class PedidoVendaController {
	@Autowired
	private PedidoVendaService pedidoVendaService;

	@GetMapping
	public ModelAndView index() {
		List<PedidoVenda> lista = pedidoVendaService.getAll();
		return new ModelAndView("pedidovenda/index", "pedidovenda", lista);
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute PedidoVenda pedidoVenda) {
		pedidoVendaService.save(pedidoVenda);
		return new ModelAndView("redirect:/pedidoVenda");
	}

	@PostMapping(params = "form")
	public ModelAndView save(@Valid PedidoVenda pedidoVenda) {
		pedidoVendaService.save(pedidoVenda);
		return new ModelAndView("redirect:/pedidoVenda");
	}

	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") PedidoVenda pedidoVenda) {
		return new ModelAndView("pedidoVenda/form", "pedidoVenda", pedidoVenda);
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") PedidoVenda pedidoVenda) {
		pedidoVendaService.delete(pedidoVenda);
		return new ModelAndView("redirect:/pedidoVenda");
	}

}
