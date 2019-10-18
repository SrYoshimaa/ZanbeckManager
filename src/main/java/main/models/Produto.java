package main.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotNull()
	@NotEmpty()
	@Column(length=800)
	private String nome;
	private String categoria;
	private String valorcusto;
	private String valorvenda;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getValorcusto() {
		return valorcusto;
	}
	public void setValorcusto(String valorcusto) {
		this.valorcusto = valorcusto;
	}
	public String getValorvenda() {
		return valorvenda;
	}
	public void setValorvenda(String valorvenda) {
		this.valorvenda = valorvenda;
	}
}
