package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Receita {

	private List<IngredienteReceita> ingredientes;

	public Receita() {
		ingredientes = new ArrayList<>();
	}

	public Receita addIngrediente(Ingrediente ingrediente, BigDecimal quantidade) {
		ingredientes.add(new IngredienteReceita(ingrediente, quantidade));
		return this;
	}

	public Receita addIngrediente(Ingrediente ingrediente) {
		ingredientes.add(new IngredienteReceita(ingrediente));
		return this;
	}
}
