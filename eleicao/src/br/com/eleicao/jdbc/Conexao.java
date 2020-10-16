package br.com.eleicao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		}
		else {
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/eleicao", "postgres", "1234567");
				System.out.println("Conectado com sucesso!");
			}

			catch (SQLException e) {
				System.out.println("Erro - Conexão " + e.getMessage());

			} catch (ClassNotFoundException e) {
				System.out.println("Erro - Driver " + e.getMessage());
			}
			return conn;
		}
	}
}
