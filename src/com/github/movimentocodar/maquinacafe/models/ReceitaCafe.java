package com.github.movimentocodar.maquinacafe.models;

public class ReceitaCafe extends Receita {

	public ReceitaCafe() {
		super.addIngrediente(Ingrediente.CAFE)
				.addIngrediente(Ingrediente.ACUCAR);
	}
}
