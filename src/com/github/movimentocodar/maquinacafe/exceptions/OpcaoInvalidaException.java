package com.github.movimentocodar.maquinacafe.exceptions;

import java.text.MessageFormat;

public class OpcaoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 2235718728815303344L;

	public OpcaoInvalidaException(int id) {
		super(MessageFormat.format("Opção {0} inválida", id));
	}
}
