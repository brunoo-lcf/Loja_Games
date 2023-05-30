package com.generation.lojagames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id // Indica que este atributo será uma chave primaria na minha tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que tera um auto-increment
	private Long id;

	@NotNull(message = "Este campo é de preenchimento obrigatório!")
	private String nome;

	@NotNull(message = "Este campo é de preenchimento obrigatório!")
	@Size(min = 15, max = 300, message = "Este campo deve conter no mínimo 15 e no máximo 300 caracteres!")
	private String descricao;

	@NotNull(message = "Este campo é de preenchimento obrigatório!")
	private String plataforma;

	@NotNull(message = "Este campo é de preenchimento obrigatório!")
	private Integer preco;

	@ManyToOne // Relação entre tabelas de muitos para um.
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	// Iinicio dos Getters and Setters criados

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

}
