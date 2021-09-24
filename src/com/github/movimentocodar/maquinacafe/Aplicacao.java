package com.github.movimentocodar.maquinacafe;

import com.github.movimentocodar.maquinacafe.models.MaquinaCafe;

public class Aplicacao {

	public static void main(String[] args) {
		System.out.println("------- Que tal uma bebida? :) -------");

		MaquinaCafe maquinaCafe = MaquinaCafe.get();
		maquinaCafe.ligar();
	}
}
