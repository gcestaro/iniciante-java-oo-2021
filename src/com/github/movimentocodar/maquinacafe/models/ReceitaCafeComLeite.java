package com.github.movimentocodar.maquinacafe.models;

public class ReceitaCafeComLeite extends Receita {

	public ReceitaCafeComLeite() {
		super.addIngrediente(Ingrediente.CAFE)
				.addIngrediente(Ingrediente.LEITE)
				.addIngrediente(Ingrediente.ACUCAR);
	}
}
