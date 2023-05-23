package com.generation.lojagames.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_lojaGames")
public class Categoria {

	@Id // Indica que este atributo será uma chave primaria na minha tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que tera um auto-increment
	private Long id;

	@NotBlank(message = "Este atributo é de preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "Este atributo deve ter no mínimo 5 caracteres e no máximo 100 caracteres")
	private String titulo;

	//Relação entre tabelas de um para muitos.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("Categoria")
	private List<Produto> produto;

	//Início dos Getters and Setters.
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
