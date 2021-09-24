package com.github.movimentocodar.maquinacafe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public Optional<OpcaoMenu> escolher(int idOpcao) {
		return opcoes.stream()
				.filter(opcao -> opcao.getId() == idOpcao)
				.findFirst();
	}
}
