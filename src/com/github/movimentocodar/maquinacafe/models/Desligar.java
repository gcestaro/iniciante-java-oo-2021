package com.github.movimentocodar.maquinacafe.models;

public class Desligar implements OpcaoMenu {

	@Override
	public void mostrar() {
		System.out.println(getId() + " - Desligar");
	}

	@Override
	public void selecionar() {
		MaquinaCafe.get().desligar();
	}

	@Override
	public int getId() {
		return 0;
	}
}
