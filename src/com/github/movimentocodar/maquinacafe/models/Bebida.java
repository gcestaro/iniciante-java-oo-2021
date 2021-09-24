package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.Objects;

import com.github.movimentocodar.maquinacafe.exceptions.ReservatorioSemAguaException;

public abstract class Bebida implements OpcaoMenu {

	private int id;

	private String nome;

	private BigDecimal precoVenda;

	private Receita receita;

	public Bebida(int id, String nome, Receita receita) {
		this(id, nome, receita, BigDecimal.ZERO);
	}

	public Bebida(int id, String nome, Receita receita, BigDecimal precoVenda) {
		this.id = id;
		this.receita = receita;
		this.nome = Objects.requireNonNull(nome, "O nome da bebida não pode ser null");
		this.precoVenda = Objects.requireNonNull(precoVenda, "O preço não pode ser null");
	}

	@Override
	public void selecionar() {
		if (!MaquinaCafe.get().temAguaParaBebida()) {
			throw new ReservatorioSemAguaException();
		}

		try {
			Thread.sleep(500);
			receita.preparar();
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("Erro ao preparar a bebida");
		}

		System.out.println("Prontinho... Retire a bebida: " + this);
	}

	@Override
	public void mostrar() {
		String mensagem = MessageFormat.format("{0} - {1} - R$ {2}", id, nome,
				precoVenda.setScale(2, RoundingMode.HALF_EVEN).toString());

		System.out.println(mensagem);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Receita getReceita() {
		return receita;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
