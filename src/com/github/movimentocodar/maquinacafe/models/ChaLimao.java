package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class ChaLimao extends Bebida {

	public ChaLimao() {
		super(4, "Ch� de lim�o", new ReceitaChaLimao(), BigDecimal.ONE);
	}

	@Override
	public void selecionar() {
		System.out.println(this.getClass().getSimpleName() + " selecionada");		
	}

}
