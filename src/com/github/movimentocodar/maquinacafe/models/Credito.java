package com.github.movimentocodar.maquinacafe.models;

public class Credito implements OpcaoMenu {

	private static final int ID = 9;

	@Override
	public void mostrar() {
		System.out.println(ID + " - Adicionar crédito");
	}

	@Override
	public void selecionar() {

	}
}
