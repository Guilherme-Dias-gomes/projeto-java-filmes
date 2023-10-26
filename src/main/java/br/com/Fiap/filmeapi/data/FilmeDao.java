package br.com.Fiap.filmeapi.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Fiap.filmeapi.model.Filme;

public class FilmeDao {
	
	private Connection conexao;
	
	public FilmeDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
	
	List <Filme> filmes = new ArrayList<>();
	
	
	public List<Filme> findAll() throws SQLException{
		var lista = new ArrayList<Filme>();
		
		var comando = conexao.prepareStatement("SELECT * FROM T_FILMES");
		var resultado = comando.executeQuery();
		
		while(resultado.next()){
            lista.add (new Filme(
					resultado.getLong("ID_FLM"),
					resultado.getString("TTL_FLM"),
					resultado.getString("SNP_FLM"),
					resultado.getString("IMG_FLM"),
					resultado.getBigDecimal("NT_FLM"),
					resultado.getBoolean("AST_FLM")
            ));
        }
		return lista;
	}
	
	
	public Filme findById() throws SQLException{
		var Filme = new Filme(null, null, null, null, null, null);
		
		var comando = conexao.prepareStatement("SELECT * FROM T_FILMES WHERE ID_FLM = ?");
		var resultado = comando.executeQuery();
		
		while (resultado.next()) {
			Filme = (new Filme(
					resultado.getLong("ID_FLM"),
					resultado.getString("TTL_FLM"),
					resultado.getString("SNP_FLM"),
					resultado.getString("IMG_FLM"),
					resultado.getBigDecimal("NT_FLM"),
					resultado.getBoolean("AST_FLM")
			));
		}
		return Filme;
	}
}