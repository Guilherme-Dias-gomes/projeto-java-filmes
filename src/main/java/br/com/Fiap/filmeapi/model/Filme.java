package br.com.Fiap.filmeapi.model;

import java.math.BigDecimal;

public record Filme(
		Long id,
		String titulo,
		String sinopse,
		String poster,
		BigDecimal nota,
		Boolean assistido
) {}
