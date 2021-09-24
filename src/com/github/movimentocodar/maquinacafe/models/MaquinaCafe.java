package com.github.movimentocodar.maquinacafe.models;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.regex.Pattern;

import com.github.movimentocodar.maquinacafe.exceptions.OpcaoInvalidaException;
import com.github.movimentocodar.maquinacafe.utils.Scanner;

public class MaquinaCafe {

	private static final Pattern PATTERN_OPCAO_MENU = Pattern.compile("\\d");
	private static final Pattern PATTERN_ALTERACAO_NIVEL_ACUCAR = Pattern.compile("[\\d+-]+");
	private static final Pattern PATTERN_DESEJA_CONTINUAR = Pattern.compile("[snSN]+");

	private static final String MENSAGEM_NIVEL_ACUCAR = "O n�vel de a�ucar atual � {0}. Digite um n�mero de 0 a 5 para alterar. Voc� tamb�m pode digitar + para aumentar ou - para diminuir em 1 n�vel: ";
	private static final String MENSAGEM_NIVEL_ACUCAR_SELECIONADO = "O n�vel de a�ucar selecionado � {0}. Deseja alterar? (s/n)";

	private static MaquinaCafe maquinaCafe;

	private Menu menu;

	private ReservatorioAgua reservatorioAgua;

	private Cofre cofre;

	private Scanner scanner;

	private NivelAcucar nivelAcucar;

	private MaquinaCafe() {
		cofre = new Cofre();
		scanner = new Scanner();
		reservatorioAgua = new ReservatorioAgua(BigDecimal.valueOf(1000));
		nivelAcucar = NivelAcucar.MODERADO;
		construirMenu();
	}

	private void construirMenu() {
		menu = new Menu()
				.addOpcao(new Cafe())
				.addOpcao(new CafeComLeite())
				.addOpcao(new Capuccino())
				.addOpcao(new ChaLimao())
				.addOpcao(new AguaQuente())
				.addOpcao(new Credito())
				.addOpcao(new ReabastecerReservatorio())
				.addOpcao(new Desligar());
	}

	public void mostrarMenu() {
		System.out.println("Op��es dispon�veis:");
		menu.mostrarOpcoes();
		System.out.println();
	}

	public void solicitarOpcao() {
		String idEscolhido = lerEntrada("Selecione uma das op��es:", PATTERN_OPCAO_MENU);

		try {
			menu.escolher(Integer.parseInt(idEscolhido));
		} catch (OpcaoInvalidaException e) {
			System.out.println("Op��o inv�lida! Tente novamente");
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

	private void reabastecer() {
		// TODO
	}

	void solicitarNivelAcucar() {
		String desejaContinuar;
		do {
			String codigoNivelAcucarDigitado = this.lerEntrada(formatarMensagemNivelAcucar(),
					PATTERN_ALTERACAO_NIVEL_ACUCAR);

			converterNivelDigitadoParaNivelAcucar(codigoNivelAcucarDigitado);

			desejaContinuar = this.lerEntrada(formatarMensagemNivelAcucarSelecionado(), PATTERN_DESEJA_CONTINUAR);

		} while (!("n".equalsIgnoreCase(desejaContinuar)));
	}

	private String formatarMensagemNivelAcucar() {
		return MessageFormat.format(MENSAGEM_NIVEL_ACUCAR, this.nivelAcucar.getNivel());
	}

	private String formatarMensagemNivelAcucarSelecionado() {
		return MessageFormat.format(MENSAGEM_NIVEL_ACUCAR_SELECIONADO, this.nivelAcucar.getNivel());
	}

	private void converterNivelDigitadoParaNivelAcucar(String codigoNivelAcucarDigitado) {
		try {
			int codigoNivel = Integer.parseInt(codigoNivelAcucarDigitado);

			this.nivelAcucar = NivelAcucar.getByOrdinal(codigoNivel);
		} catch (NumberFormatException e) {
			switch (codigoNivelAcucarDigitado) {
			case "+":
				this.nivelAcucar = this.nivelAcucar.aumentar();
				break;
			case "-":
				this.nivelAcucar = this.nivelAcucar.diminuir();
				break;
			}
		}
	}

	public static MaquinaCafe get() {
		if (maquinaCafe == null) {
			maquinaCafe = new MaquinaCafe();
		}

		return maquinaCafe;
	}
}
