package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class Capuccino extends Bebida {

	public Capuccino() {
		super(3, "Capuccino", new ReceitaCapuccino(), new BigDecimal("1.5"));
	}

	@Override
	public void selecionar() {
		System.out.println(this.getClass().getSimpleName() + " selecionada");		
	}

}
