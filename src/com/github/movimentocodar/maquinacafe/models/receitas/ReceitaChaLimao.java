package com.github.movimentocodar.maquinacafe.models.receitas;

import com.github.movimentocodar.maquinacafe.models.ingredientes.Ingrediente;

public class ReceitaChaLimao extends Receita {

	public ReceitaChaLimao() {
		super.addIngrediente(Ingrediente.CHA_LIMAO)
				.addIngrediente(Ingrediente.ACUCAR);
	}

	@Override
	public void preparar() {
		adicionarAcucar();

		new ReceitaAgua().preparar();
		
		System.out.println("Adicionando chá de limão...");
	}
}
