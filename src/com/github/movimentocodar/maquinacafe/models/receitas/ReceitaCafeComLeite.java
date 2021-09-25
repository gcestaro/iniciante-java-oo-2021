package com.github.movimentocodar.maquinacafe.models.receitas;

import com.github.movimentocodar.maquinacafe.models.ingredientes.Ingrediente;

public class ReceitaCafeComLeite extends Receita {

	public ReceitaCafeComLeite() {
		super.addIngrediente(Ingrediente.CAFE)
				.addIngrediente(Ingrediente.LEITE)
				.addIngrediente(Ingrediente.ACUCAR);
	}

	@Override
	public void preparar() {
		new ReceitaCafe().preparar();
		
		System.out.println("Adicionando leite em pó...");
	}
}
