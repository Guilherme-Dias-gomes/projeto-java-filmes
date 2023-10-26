package br.com.Fiap.filmeapi.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
	static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    static final String USER = "rm99577";
    static final String PASS = "040705";
    
    private static Connection conexao;

    public static Connection getConnection() throws SQLException{
        if(conexao == null || conexao.isClosed()){
            conexao = DriverManager.getConnection(URL, USER, PASS);
        }
        return conexao;
    }
    
}