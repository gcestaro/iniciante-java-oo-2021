package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import com.github.movimentocodar.maquinacafe.exceptions.OpcaoInvalidaException;
import com.github.movimentocodar.maquinacafe.exceptions.ReservatorioSemAguaException;
import com.github.movimentocodar.maquinacafe.models.bebidas.AguaQuente;
import com.github.movimentocodar.maquinacafe.models.bebidas.Cafe;
import com.github.movimentocodar.maquinacafe.models.bebidas.CafeComLeite;
import com.github.movimentocodar.maquinacafe.models.bebidas.Capuccino;
import com.github.movimentocodar.maquinacafe.models.bebidas.ChaLimao;
import com.github.movimentocodar.maquinacafe.models.cofre.Cofre;
import com.github.movimentocodar.maquinacafe.models.menu.Credito;
import com.github.movimentocodar.maquinacafe.models.menu.Desligar;
import com.github.movimentocodar.maquinacafe.models.menu.Menu;
import com.github.movimentocodar.maquinacafe.models.menu.ReabastecerReservatorio;
import com.github.movimentocodar.maquinacafe.models.reservatorio.ReservatorioAgua;
import com.github.movimentocodar.maquinacafe.utils.Scanner;

public class MaquinaCafe {

	private static final Pattern PATTERN_OPCAO_MENU = Pattern.compile("\\d");

	private static MaquinaCafe maquinaCafe;

	private Menu menu;

	private Cofre cofre;

	private Scanner scanner;

	private ReservatorioAgua reservatorioAgua;

	private MaquinaCafe() {
		cofre = new Cofre();
		scanner = new Scanner();
		reservatorioAgua = new ReservatorioAgua(BigDecimal.valueOf(1000));
		construirMenu();
	}

	private void construirMenu() {
		menu = new Menu()
				.addOpcao(new Cafe())
				.addOpcao(new CafeComLeite())
				.addOpcao(new Capuccino())
				.addOpcao(new ChaLimao())
				.addOpcao(new AguaQuente())
				.addOpcao(new ReabastecerReservatorio())
				.addOpcao(new Credito())
				.addOpcao(new Desligar());
	}

	public void mostrarMenu() {
		System.out.println();
		System.out.println("Opções disponíveis:");
		menu.mostrarOpcoes();
		System.out.println();
	}

	public void solicitarOpcao() {
		int idEscolhido = Integer.parseInt(lerEntrada("Selecione uma das opções:", PATTERN_OPCAO_MENU));

		try {
			menu.escolher(idEscolhido)
					.orElseThrow(() -> new OpcaoInvalidaException(idEscolhido))
					.selecionar();
		} catch (OpcaoInvalidaException e) {
			System.out.println("Opção inválida! Tente novamente");
			solicitarOpcao();
		} catch (ReservatorioSemAguaException e) {
			System.out.println("Por favor, reabasteça o reservatório de água.");
			solicitarOpcao();
		}
	}

	public String lerEntrada(String mensagem, Pattern regex) {
		return scanner.scan(mensagem, regex);
	}

	public void ligar() {
		do {
			mostrarMenu();
			solicitarOpcao();
		} while (true);
	}

	public void desligar() {
		System.out.println("Desligando...");
		scanner.close();
		System.exit(-1);
	}

	public void reabastecer() {
		reservatorioAgua.completar();
	}

	public boolean temAguaParaBebida() {
		return reservatorioAgua.temDisponivelParaBebida();
	}

	public void utilizarAgua() {
		reservatorioAgua.utilizarAgua(BigDecimal.valueOf(50));
	}

	public static MaquinaCafe get() {
		if (maquinaCafe == null) {
			maquinaCafe = new MaquinaCafe();
		}

		return maquinaCafe;
	}
}
