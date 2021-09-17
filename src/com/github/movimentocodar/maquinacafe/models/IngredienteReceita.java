package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class IngredienteReceita {

	private Ingrediente ingrediente;

	private BigDecimal quantidade;

	public IngredienteReceita(Ingrediente ingrediente) {
		this(ingrediente, ingrediente.getQuantidade());
	}

	public IngredienteReceita(Ingrediente ingrediente, BigDecimal quantidade) {
		this.ingrediente = ingrediente;
		this.quantidade = quantidade;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

}
