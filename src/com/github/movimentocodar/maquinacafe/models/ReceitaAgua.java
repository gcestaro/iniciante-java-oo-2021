package com.github.movimentocodar.maquinacafe.models;

public class ReceitaAgua extends Receita {

	public ReceitaAgua() {
		super.addIngrediente(Ingrediente.AGUA);
	}

	@Override
	public void preparar() {
		MaquinaCafe.get().utilizarAgua();

		System.out.println("Fervendo a água...");
	}
}
