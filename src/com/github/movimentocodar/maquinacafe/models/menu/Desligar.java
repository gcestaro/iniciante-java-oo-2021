package com.github.movimentocodar.maquinacafe.models.menu;

import com.github.movimentocodar.maquinacafe.models.MaquinaCafe;

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
