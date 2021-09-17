package com.github.movimentocodar.maquinacafe.models;

import java.util.List;

public class MaquinaCafe {

	private static MaquinaCafe maquinaCafe;

	private Menu menu;

	private List<IngredienteReceita> ingredientesReceita;

	private ReservatorioAgua reservatorioAgua;

	private Cofre cofre;

	private MaquinaCafe() {
		construirMenu();
	}

	private void construirMenu() {
		menu = new Menu()
				.addOpcao(new Cafe())
				.addOpcao(new CafeComLeite())
				.addOpcao(new Capuccino())
				.addOpcao(new ChaLimao())
				.addOpcao(new AguaQuente())
				.addOpcao(new Credito());

	}

	public void mostrarMenu() {
		menu.mostrarOpcoes();
	}

	public static MaquinaCafe get() {
		if (maquinaCafe == null) {
			maquinaCafe = new MaquinaCafe();
		}

		return maquinaCafe;
	}
}
