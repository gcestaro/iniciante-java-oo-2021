package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class ChaLimao extends Bebida {

	public ChaLimao() {
		super(4, "Chá de limão", new ReceitaChaLimao(), BigDecimal.ONE);
	}

	@Override
	public void selecionar() {
		// TODO Auto-generated method stub
		
	}

}
