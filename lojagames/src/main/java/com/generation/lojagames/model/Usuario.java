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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="O atributo Nome é obrigatório")
	private String nome;
	
	@NotNull(message="O atributo Usuario é obrigatório")
	@Email(message = "O atributo Usuario vai receber um e-mail válido")
	private String usuario;
	
	@NotBlank(message = "O atributo senha é obrigatório")
	@Size(min = 8, message="A senha deverá conter no mínimo 8 caracteres")
	private String senha;
	
	@Size(max = 5000, message = "O link da foto não deve ser maior que 5000 caracteres")
	private String foto;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto>produto;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Produto> getPostagem() {
		return produto;
	}

	public void setPostagem(List<Produto> produto) {
		this.produto = produto;
	}
	
	

}
