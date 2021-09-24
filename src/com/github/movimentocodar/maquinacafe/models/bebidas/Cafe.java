package com.github.movimentocodar.maquinacafe.models.bebidas;

import java.math.BigDecimal;

import com.github.movimentocodar.maquinacafe.models.receitas.ReceitaCafe;

public class Cafe extends Bebida {

	public Cafe() {
		super(1, "Café", new ReceitaCafe(), new BigDecimal("0.5"));
	}
}
