package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class ReceitaCafe extends Receita {

	public ReceitaCafe() {
		super.addIngrediente(Ingrediente.AGUA)
				.addIngrediente(Ingrediente.CAFE)
				.addIngrediente(Ingrediente.ACUCAR);
	}

	@Override
	public void preparar() {
		new ReceitaAgua().preparar();

		System.out.println("Adicionando pó de café...");

		adicionarAcucar();
	}

	private void adicionarAcucar() {
		String quantidadeAcucar = MaquinaCafe.get()
				.lerEntrada("Quanto de açúcar? (Escolha um valor entre 0 e 5)", Pattern.compile("[012345]+"));

		substituirQuantidadeDoIngrediente(Ingrediente.ACUCAR, new BigDecimal(quantidadeAcucar));

		System.out.println("Adicionando açúcar...");
	}
}
