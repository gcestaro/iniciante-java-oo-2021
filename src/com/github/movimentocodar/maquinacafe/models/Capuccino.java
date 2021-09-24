package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class Capuccino extends Bebida {

	private static final String DESCRICAO = "Capuccino";

	public Capuccino() {
		super(3, DESCRICAO, new ReceitaCapuccino(), new BigDecimal("1.5"));
	}
}
