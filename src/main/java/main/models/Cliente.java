package main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String CGC;
	@Column(length=800)
	private String nome;
	private String telefone;
	private String localidade;
	
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
	public String getCGC() {
		return CGC;
	}
	public void setCGC(String cGC) {
		CGC = cGC;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
