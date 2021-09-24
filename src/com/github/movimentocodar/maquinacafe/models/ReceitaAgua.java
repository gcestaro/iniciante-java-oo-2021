package com.github.movimentocodar.maquinacafe.models;

public class ReceitaAgua extends Receita {

	public ReceitaAgua() {
		super.addIngrediente(Ingrediente.AGUA);
	}

	@Override
	public void preparar() {
		System.out.println("Fervendo a �gua...");
	}
}
