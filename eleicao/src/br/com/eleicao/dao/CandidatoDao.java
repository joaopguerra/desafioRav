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

	public void insert(Candidato candidato) {
		String sql = "INSERT INTO candidatos (nome, numero) values (?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, candidato.getNome());
			ps.setString(2, candidato.getNumero());
			ps.executeUpdate();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		}

	}

	public void update(Candidato candidato) {

		try {
			String sql = "UPDATE candidatos SET nome = ?, numero = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, candidato.getNome());
			ps.setString(2, candidato.getNumero());
			ps.setInt(3, candidato.getId());

			ps.executeUpdate();

			System.out.println("Alterado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * public void update(Candidato candidato) { String sql =
	 * "UPDATE candidatos SET nome = ?, numero = ? WHERE id = ?";
	 * 
	 * try { PreparedStatement ps = conn.prepareStatement(sql); ps.setString(1,
	 * candidato.getNome()); ps.setString(2, candidato.getNumero()); ps.setInt(3,
	 * candidato.getId());
	 * 
	 * ps.executeUpdate();
	 * 
	 * System.out.println("Alterado com sucesso!");
	 * 
	 * } catch (SQLException e) { System.out.println("Erro " + e.getMessage()); } }
	 */

	/*
	 * public void delete(int id) { String sql =
	 * "DELETE FROM candidatos WHERE id = ?";
	 * 
	 * try { PreparedStatement ps = conn.prepareStatement(sql); ps.setInt(1, id);
	 * ps.executeUpdate();
	 * 
	 * System.out.println("Deletado com sucesso!");
	 * 
	 * } catch (SQLException e) { System.out.println("Erro " + e.getMessage()); } }
	 */

	public void delete(String nome) {
		String sql = "DELETE FROM candidatos WHERE nome = '" + nome + "'";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();

			System.out.println("Deletado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		}
	}

	public List<Candidato> listar() throws Exception {

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
	
	public Candidato consultar(Integer id) {
		Candidato cand = null;
		String sql = "SELECT * FROM candidatos WHERE id= ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cand = new Candidato();
				cand.setId(rs.getInt("id"));
				cand.setNome(rs.getString("nome"));
				cand.setNumero(rs.getString("numero"));
			}
			System.out.println("Encontrado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		}

		return cand;
	} 
	
	
	public Candidato consultarPorNumero(String numero) throws Exception {
		
		String sql = "SELECT * FROM candidatos WHERE numero='" + numero + "'";

		
			PreparedStatement ps = conn.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Candidato cand = new Candidato();
				cand.setId(rs.getInt("id"));
				cand.setNome(rs.getString("nome"));
				cand.setNumero(rs.getString("numero"));
				return cand;
			}
			System.out.println("Encontrado com sucesso!");
		 
		return null;
	} 
	
}
