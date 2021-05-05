package com.dev.dsvendas.dto;

import java.io.Serializable;

import com.dev.dsvendas.entities.Seller;

public class SellerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	public SellerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SellerDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public SellerDTO(Seller seller) {
		super();
		this.id = seller.getId();
		this.nome = seller.getName();
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

}
