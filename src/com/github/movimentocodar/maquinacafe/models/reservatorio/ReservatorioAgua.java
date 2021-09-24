package com.github.movimentocodar.maquinacafe.models.reservatorio;

import java.math.BigDecimal;

import com.github.movimentocodar.maquinacafe.exceptions.ReservatorioSemAguaException;

public class ReservatorioAgua {

	private static final BigDecimal CAPACIDADE = BigDecimal.valueOf(1000);;

	private BigDecimal quantidade;

	public ReservatorioAgua(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getCapacidade() {
		return CAPACIDADE;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void completar() {
		abastecer(CAPACIDADE.subtract(quantidade));
	}

	public void abastecer(BigDecimal quantidade) {
		System.out.println("Abastecendo o reservatório com " + quantidade.setScale(2) + "ml.");

		BigDecimal soma = this.quantidade.add(quantidade);

		if (soma.compareTo(CAPACIDADE) > 0) {
			throw new IllegalStateException("Excedeu a capacidade do reservatório");
		}

		this.quantidade = soma;
	}

	public boolean temDisponivelParaBebida() {
		return BigDecimal.valueOf(50).compareTo(this.quantidade) <= 0;
	}

	public void utilizarAgua(BigDecimal quantidade) {
		if (quantidade.compareTo(this.quantidade) > 0) {
			throw new ReservatorioSemAguaException();
		}

		this.quantidade = this.quantidade.subtract(quantidade);
	}
}
