package br.com.Fiap.filmeapi.service;

import java.sql.SQLException;
import java.util.List;

import br.com.Fiap.filmeapi.data.FilmeDao;
import br.com.Fiap.filmeapi.model.Filme;

public class FilmeService {
	
	FilmeDao dao;
	
	public FilmeService() throws SQLException {
		dao = new FilmeDao();
	}
	
	
	public List<Filme> findAll() throws SQLException {
		
		return dao.findAll();
		
	}
	public Filme findById() throws SQLException {
		return dao.findById();
	}

	public boolean save(Filme filmes) {
		if (filmes.id() == null) return false;
		if (filmes.titulo().length() < 5) return false;
		if (filmes.sinopse().length() < 10) return false;
		
		return true;		
	}
	
	private boolean verificar(Filme filme) {
		if (filme.titulo().isEmpty()) return false;
		if (filme.sinopse().length() < 10) return false;
		if (!filme.poster().startsWith("http")) return false;
		if (filme.nota() < 0 || filme.nota() > 5) return false;
		
		return true;
	}
	
	public boolean atualizar(Filme filme) {
		if (!verificar(filme)) return false;
		
		dao.update(filme);
		return true;
		
	}
	
}
