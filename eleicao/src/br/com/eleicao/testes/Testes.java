package br.com.eleicao.testes;

import java.sql.SQLException;

import br.com.eleicao.dao.CandidatoDao;
import br.com.eleicao.jdbc.Conexao;
import br.com.eleicao.model.Candidato;

public class Testes {

	public static void main(String[] args) throws SQLException {
		Conexao.getConnection();
		// testeInsert();
		// testeUpdate();
		// testeDelete();
		 testeConsultar();

	}

	public static void testeInsert() throws SQLException {
		Candidato cand = new Candidato();
		cand.setNome("Candidato B");
		cand.setNumero("99");

		CandidatoDao candDao = new CandidatoDao();
		candDao.insert(cand);
	}

	public static void testeUpdate() throws SQLException {
		Candidato cand = new Candidato();
		cand.setNome("Candidato A55");
		cand.setNumero("55");
		cand.setId(12);

		CandidatoDao candDao = new CandidatoDao();
		candDao.update(cand);
	}

	public static void testeDelete() throws SQLException {
		Candidato cand = new Candidato();
		cand.setNome("Joao");

		CandidatoDao candDao = new CandidatoDao();
		candDao.delete(cand.getNome());

	}
	
	public static void testeConsultar() throws SQLException {
		Candidato cand = new Candidato();
		cand.setNome("Alex");

		System.out.println(cand);

	}

}
