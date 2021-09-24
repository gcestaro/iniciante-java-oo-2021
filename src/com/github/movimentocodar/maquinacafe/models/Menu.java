package com.github.movimentocodar.maquinacafe.models;

import java.util.ArrayList;
import java.util.List;

import com.github.movimentocodar.maquinacafe.exceptions.OpcaoInvalidaException;

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

	public void escolher(int idOpcao) {
		OpcaoMenu opcaoEscolhida = opcoes.stream()
				.filter(opcao -> opcao.getId() == idOpcao)
				.findFirst()
				.orElseThrow(() -> new OpcaoInvalidaException(idOpcao));
		
		opcaoEscolhida.selecionar();
	}
}
