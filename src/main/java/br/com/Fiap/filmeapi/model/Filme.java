package br.com.Fiap.filmeapi.model;


public record Filme(
		Long id,
		String titulo,
		String sinopse,
		String poster,
		Double nota,
		Boolean assistido
) {}
