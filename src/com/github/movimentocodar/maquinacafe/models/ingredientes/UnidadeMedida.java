package com.github.movimentocodar.maquinacafe.models.ingredientes;

public enum UnidadeMedida {

	GRAMAS("g"),
	MILIGRAMAS("mg"),
	LITROS("l"),
	MILILITROS("ml");

	private String abreviacao;

	UnidadeMedida(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public String getAbreviacao() {
		return abreviacao;
	}
}
