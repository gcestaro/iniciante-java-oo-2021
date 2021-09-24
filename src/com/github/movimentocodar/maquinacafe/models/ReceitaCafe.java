package com.github.movimentocodar.maquinacafe.models;

public class ReceitaCafe extends Receita {

	public ReceitaCafe() {
		super.addIngrediente(Ingrediente.AGUA)
				.addIngrediente(Ingrediente.CAFE)
				.addIngrediente(Ingrediente.ACUCAR);
	}

	@Override
	public void preparar() {
		adicionarAcucar();

		new ReceitaAgua().preparar();

		System.out.println("Adicionando pó de café...");
	}
}
