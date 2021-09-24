package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;

public class ReservatorioAgua {

	private final BigDecimal capacidade;

	private BigDecimal quantidade;

	public ReservatorioAgua() {
		capacidade = BigDecimal.valueOf(1000);
	}

	public ReservatorioAgua(BigDecimal quantidade) {
		this();
		this.quantidade = quantidade;
	}

	public BigDecimal getCapacidade() {
		return capacidade;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void abastecer(BigDecimal quantidade) {
		BigDecimal soma = this.quantidade.add(quantidade);

		if (soma.compareTo(capacidade) > 0) {
			throw new IllegalStateException("Excedeu a capacidade do reservatório");
		}

		this.quantidade = soma;
	}

	public boolean temDisponivelParaBebida() {
		return BigDecimal.valueOf(50).compareTo(this.quantidade) <= 0;
	}
}
