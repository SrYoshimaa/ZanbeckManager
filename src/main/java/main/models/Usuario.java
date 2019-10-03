package main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	@OneToMany
	private List<PedidoVenda> pedidovenda = new ArrayList<>();
	
	
	public List<PedidoVenda> getPedidovenda() {
		return pedidovenda;
	}
	public void setPedidovenda(List<PedidoVenda> pedidovenda) {
		this.pedidovenda = pedidovenda;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
