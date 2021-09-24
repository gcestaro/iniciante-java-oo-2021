package com.github.movimentocodar.maquinacafe.models;

public class ReabastecerReservatorio implements OpcaoMenu {

	@Override
	public void mostrar() {
		System.out.println(getId() + " - Reabastecer reservatório");
	}

	@Override
	public void selecionar() {
		System.out.println(this.getClass().getSimpleName() + " selecionada");

		MaquinaCafe.get().reabastecer();
	}

	@Override
	public int getId() {
		return 8;
	}

}
