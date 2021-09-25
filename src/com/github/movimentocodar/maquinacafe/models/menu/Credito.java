package com.github.movimentocodar.maquinacafe.models.menu;

import java.util.ArrayList;
import java.util.List;

import com.github.movimentocodar.maquinacafe.models.cofre.CartaoDebito;
import com.github.movimentocodar.maquinacafe.models.cofre.Dinheiro;
import com.github.movimentocodar.maquinacafe.models.cofre.OpcaoCredito;

public class Credito implements OpcaoMenu {

	private static final int ID = 9;

	private List<OpcaoCredito> opcoesCredito;

	public Credito() {
		opcoesCredito = new ArrayList<>();
		opcoesCredito.add(new Dinheiro());
		opcoesCredito.add(new CartaoDebito());
	}

	@Override
	public void mostrar() {
		System.out.println(getId() + " - Adicionar crédito");
	}

	@Override
	public void selecionar() {
		
		System.out.println(this.getClass().getSimpleName() + " selecionada");
	}

	@Override
	public int getId() {
		return ID;
	}
}
