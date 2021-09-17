package com.github.movimentocodar.maquinacafe.models;

public class ReceitaChaLimao extends Receita {

	public ReceitaChaLimao() {
		super.addIngrediente(Ingrediente.CHA_LIMAO)
				.addIngrediente(Ingrediente.ACUCAR);
	}
}
