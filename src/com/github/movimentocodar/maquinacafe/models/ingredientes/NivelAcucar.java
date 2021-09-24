package com.github.movimentocodar.maquinacafe.models.ingredientes;

import java.util.stream.Stream;

public enum NivelAcucar {
	SEM_ACUCAR,
	QUASE_SEM_ACUCAR,
	POUCO_ACUCAR,
	MODERADO,
	MAIS_ACUCAR,
	MUITO_ACUCAR;

	public int getNivel() {
		return ordinal();
	}

	public NivelAcucar aumentar() {
		int proximoNivel = ordinal() + 1;

		return proximoNivel > MUITO_ACUCAR.ordinal() ? MUITO_ACUCAR : getByOrdinal(proximoNivel);
	}

	public NivelAcucar diminuir() {
		int proximoNivel = ordinal() - 1;

		return proximoNivel < 0 ? SEM_ACUCAR : getByOrdinal(proximoNivel);
	}

	public static NivelAcucar getByOrdinal(int ordinal) {
		return Stream.of(values())
				.filter(value -> value.ordinal() == ordinal)
				.findFirst()
				.orElse(MODERADO);
	}
}
