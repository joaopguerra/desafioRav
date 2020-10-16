package br.com.eleicao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.eleicao.jdbc.Conexao;
import br.com.eleicao.model.Candidato;

public class CandidatoDao {

	private Connection conn = Conexao.getConnection();

	public void insert(Candidato candidato) throws SQLException {
		String sql = "INSERT INTO candidatos (nome, numero) values (?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, candidato.getNome());
			ps.setString(2, candidato.getNumero());
			ps.execute();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		} 

	}

	public void update(Candidato candidato) throws SQLException {
		String sql = "UPDATE candidatos SET nome = ?, numero = ? WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, candidato.getNome());
			ps.setString(2, candidato.getNumero());
			ps.setInt(3, candidato.getId());

			ps.execute();

			System.out.println("Alterado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		} 
	}

	public void delete(Candidato candidato) throws SQLException {
		String sql = "DELETE FROM candidatos WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, candidato.getId());

			ps.execute();
			ps.close();

			System.out.println("Deletado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		} 
	}
	
	public List<Candidato> listar() throws SQLException {
		List<Candidato> lista = new ArrayList<Candidato>();
		
		String sql = "SELECT * FROM candidatos";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Candidato cand = new Candidato();
			
			cand.setId(rs.getInt("id"));
			cand.setNome(rs.getString("nome"));
			cand.setNumero(rs.getString("numero"));
			
			lista.add(cand);
		}		
		return lista;
	}
}
