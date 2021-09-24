package com.github.movimentocodar.maquinacafe.utils;

import java.io.Closeable;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Scanner implements Closeable {

	private final java.util.Scanner scanner;

	public Scanner() {
		scanner = new java.util.Scanner(System.in);
	}

	public String scan(String mensagem, Pattern regexEsperada) {
		String codigo;

		do {
			System.out.print(mensagem);

			try {
				codigo = scanner.next(regexEsperada);
			} catch (InputMismatchException ime) {
				System.out.println("Não foi possível identificar sua escolha. Por favor, tente novamente.");
				codigo = null;
				scanner.next();
			} catch (Exception e) {
				codigo = null;
				scanner.next();
				System.out.println(e.getMessage());
			}

			System.out.println();
		} while (codigo == null || codigo.length() == 0);

		return codigo;
	}

	@Override
	public void close() {
		this.scanner.close();
	}
}