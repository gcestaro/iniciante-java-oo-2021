package com.github.movimentocodar.maquinacafe.models.bebidas;

import java.math.BigDecimal;

import com.github.movimentocodar.maquinacafe.models.receitas.ReceitaCafeComLeite;

public class CafeComLeite extends Bebida {

	public CafeComLeite() {
		super(2, "Café c/ Leite", new ReceitaCafeComLeite(), BigDecimal.ONE);
	}
}
