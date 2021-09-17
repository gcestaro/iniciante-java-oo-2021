package com.github.movimentocodar.maquinacafe.models;

public class ReceitaCapuccino extends Receita {

	public ReceitaCapuccino() {
		super.addIngrediente(Ingrediente.CAFE)
				.addIngrediente(Ingrediente.LEITE)
				.addIngrediente(Ingrediente.CHOCOLATE)
				.addIngrediente(Ingrediente.ACUCAR);
	}
}
