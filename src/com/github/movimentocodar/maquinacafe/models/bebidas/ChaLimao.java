package com.github.movimentocodar.maquinacafe.models.bebidas;

import java.math.BigDecimal;

import com.github.movimentocodar.maquinacafe.models.receitas.ReceitaChaLimao;

public class ChaLimao extends Bebida {

	public ChaLimao() {
		super(4, "Ch� de lim�o", new ReceitaChaLimao(), BigDecimal.ONE);
	}
}