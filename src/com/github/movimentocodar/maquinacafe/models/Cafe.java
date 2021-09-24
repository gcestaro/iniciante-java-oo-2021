package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class Cafe extends Bebida {

	public Cafe() {
		super(1, "Café", new ReceitaCafe(), new BigDecimal("0.5"));
	}
}
