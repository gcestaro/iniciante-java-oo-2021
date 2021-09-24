package com.github.movimentocodar.maquinacafe.models.ingredientes;

import java.math.BigDecimal;

public enum Ingrediente {
	CAFE(BigDecimal.ONE, UnidadeMedida.GRAMAS),
	LEITE(BigDecimal.ONE, UnidadeMedida.GRAMAS),
	CHOCOLATE(BigDecimal.ONE, UnidadeMedida.GRAMAS),
	CHA_LIMAO(BigDecimal.ONE, UnidadeMedida.GRAMAS),
	ACUCAR(BigDecimal.valueOf(3), UnidadeMedida.GRAMAS),
	AGUA(new BigDecimal(50), UnidadeMedida.MILILITROS);

	private BigDecimal quantidade;

	private UnidadeMedida unidadeMedida;

	Ingrediente(BigDecimal quantidade, UnidadeMedida unidadeMedida) {
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
}
