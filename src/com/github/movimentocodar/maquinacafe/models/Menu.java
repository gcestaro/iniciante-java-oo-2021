package com.github.movimentocodar.maquinacafe.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private List<OpcaoMenu> opcoes;

	public Menu() {
		opcoes = new ArrayList<>();
	}

	public List<OpcaoMenu> getOpcoes() {
		return opcoes;
	}

	public Menu addOpcao(OpcaoMenu opcao) {
		opcoes.add(opcao);
		return this;
	}

	public void mostrarOpcoes() {
		opcoes.forEach(OpcaoMenu::mostrar);
	}
}
