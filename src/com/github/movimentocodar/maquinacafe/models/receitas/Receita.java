package com.github.movimentocodar.maquinacafe.models.receitas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.github.movimentocodar.maquinacafe.models.MaquinaCafe;
import com.github.movimentocodar.maquinacafe.models.ingredientes.Ingrediente;
import com.github.movimentocodar.maquinacafe.models.ingredientes.IngredienteReceita;

public abstract class Receita {

	private List<IngredienteReceita> ingredientes;

	public Receita() {
		ingredientes = new ArrayList<>();
	}

	public abstract void preparar();

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

	public void adicionarAcucar() {
		String quantidadeAcucar = MaquinaCafe.get()
				.lerEntrada("Quanto de açúcar? (Escolha um valor entre 0 e 5)", Pattern.compile("[012345]+"));

		substituirQuantidadeDoIngrediente(Ingrediente.ACUCAR, new BigDecimal(quantidadeAcucar));

		System.out.println("Adicionando açúcar...");
	}

	public void substituirQuantidadeDoIngrediente(Ingrediente ingrediente, BigDecimal quantidade) {
		ingredientes.stream()
				.filter(ingredienteReceita -> ingredienteReceita.getIngrediente() == ingrediente)
				.findFirst()
				.ifPresent(ingredienteReceita -> ingredienteReceita.setQuantidade(quantidade));
	}

	public List<IngredienteReceita> getIngredientes() {
		return ingredientes;
	}

	private boolean ingredienteJaAdicionado(Ingrediente ingrediente) {
		return ingredientes.stream().anyMatch(ingredienteReceita -> ingredienteReceita.getIngrediente() == ingrediente);
	}
}
