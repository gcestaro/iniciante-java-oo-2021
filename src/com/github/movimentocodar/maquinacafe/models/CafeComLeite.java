package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class CafeComLeite extends Bebida {

	public CafeComLeite() {
		super(2, "Café c/ Leite", new ReceitaCafeComLeite(), BigDecimal.ONE);
	}

	@Override
	public void selecionar() {
		System.out.println(this.getClass().getSimpleName() + " selecionada");		
	}

}
