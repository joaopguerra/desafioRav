package br.com.eleicao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.eleicao.dao.CandidatoDao;
import br.com.eleicao.model.Candidato;

@WebServlet("/consultaCandidato")
public class ConsultaCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CandidatoDao candDao = new CandidatoDao();
       
   
    public ConsultaCandidato() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			String numeroCandidato = request.getParameter("numeroCandidato");
			Candidato cand = candDao.consultarPorNumero(numeroCandidato);
			
			PrintWriter pw = response.getWriter();
			pw.println(cand.getNome());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
