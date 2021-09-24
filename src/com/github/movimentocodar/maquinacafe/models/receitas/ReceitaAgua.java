package com.github.movimentocodar.maquinacafe.models.receitas;

import com.github.movimentocodar.maquinacafe.models.MaquinaCafe;
import com.github.movimentocodar.maquinacafe.models.ingredientes.Ingrediente;

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
