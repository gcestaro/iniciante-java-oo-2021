package com.github.movimentocodar.maquinacafe.models;

public class ReceitaChaLimao extends Receita {

	public ReceitaChaLimao() {
		super.addIngrediente(Ingrediente.CHA_LIMAO)
				.addIngrediente(Ingrediente.ACUCAR);
	}

	@Override
	public void preparar() {
		adicionarAcucar();

		new ReceitaAgua().preparar();
		
		System.out.println("Adicionando ch� de lim�o...");
	}
}
