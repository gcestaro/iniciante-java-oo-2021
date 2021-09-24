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
		if (ingredienteJaAdicionado(ingrediente)) {
			substituirQuantidadeDoIngrediente(ingrediente, ingrediente.getQuantidade());
		} else {
			ingredientes.add(new IngredienteReceita(ingrediente, quantidade));
		}

		return this;
	}

	public Receita addIngrediente(Ingrediente ingrediente) {
		if (ingredienteJaAdicionado(ingrediente)) {
			substituirQuantidadeDoIngrediente(ingrediente, ingrediente.getQuantidade());
		} else {
			ingredientes.add(new IngredienteReceita(ingrediente));
		}

		return this;
	}

	private boolean ingredienteJaAdicionado(Ingrediente ingrediente) {
		return ingredientes.stream().anyMatch(ingredienteReceita -> ingredienteReceita.getIngrediente() == ingrediente);
	}

	public abstract void preparar();

	public void substituirQuantidadeDoIngrediente(Ingrediente ingrediente, BigDecimal quantidade) {
		ingredientes.stream()
				.filter(ingredienteReceita -> ingredienteReceita.getIngrediente() == ingrediente)
				.findFirst()
				.ifPresent(ingredienteReceita -> ingredienteReceita.setQuantidade(quantidade));
	}

	public List<IngredienteReceita> getIngredientes() {
		return ingredientes;
	}

}
