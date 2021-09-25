package com.github.movimentocodar.maquinacafe.models.bebidas;

import com.github.movimentocodar.maquinacafe.models.receitas.ReceitaAgua;

public class AguaQuente extends Bebida {

	public AguaQuente() {
		super(5, "Água Quente", new ReceitaAgua());
	}
}
