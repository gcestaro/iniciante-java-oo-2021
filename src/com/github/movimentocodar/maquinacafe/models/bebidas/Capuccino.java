package com.github.movimentocodar.maquinacafe.models.bebidas;

import java.math.BigDecimal;

import com.github.movimentocodar.maquinacafe.models.receitas.ReceitaCapuccino;

public class Capuccino extends Bebida {

	private static final String DESCRICAO = "Capuccino";

	public Capuccino() {
		super(3, DESCRICAO, new ReceitaCapuccino(), new BigDecimal("1.5"));
	}
}
