package main.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PedidoVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double valor;
	@Temporal(value=TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy H:mm")
	private Date dataVenda;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="pedidoVenda_id")
	private List<PedidoVendaRealizado> listaItemPedido = new ArrayList<PedidoVendaRealizado>();
	
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=true)
	private Cliente cliente;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=true)
	private Estoque estoque;

	public List<PedidoVendaRealizado> getListaItemPedido() {
		return listaItemPedido;
	}

	public void setListaItemPedido(List<PedidoVendaRealizado> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
}