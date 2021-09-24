package com.github.movimentocodar.maquinacafe.models.receitas;

import com.github.movimentocodar.maquinacafe.models.ingredientes.Ingrediente;

public class ReceitaCapuccino extends Receita {

	public ReceitaCapuccino() {
		super.addIngrediente(Ingrediente.CAFE)
				.addIngrediente(Ingrediente.LEITE)
				.addIngrediente(Ingrediente.CHOCOLATE)
				.addIngrediente(Ingrediente.ACUCAR);
	}

	@Override
	public void preparar() {
		new ReceitaCafeComLeite().preparar();

		System.out.println("Adicionando chocolate em pó...");
	}
}
