package br.com.eleicao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.eleicao.dao.CandidatoDao;
import br.com.eleicao.model.Candidato;

@WebServlet("/salvarCandidato")
public class CandidatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CandidatoDao candDao = new CandidatoDao();
	Candidato cand = new Candidato();

	public CandidatoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());		
		

		try {
			String acao = request.getParameter("acao");
			String nome = request.getParameter("nome");

			if (acao.equals("delete")) {
				candDao.delete(nome);
				RequestDispatcher view = request.getRequestDispatcher("cadastro.jsp");
				request.setAttribute("candidatos", candDao.listar());
				view.forward(request, response);
			}
			
			else if (acao.equals("update")) {
					String id = request.getParameter("id");
					Candidato cand = candDao.consultar(Integer.parseInt(id));
					
					RequestDispatcher view = request.getRequestDispatcher("cadastro.jsp");
					request.setAttribute("candidato", cand);
					request.setAttribute("candidatos", candDao.listar());
					view.forward(request, response);
				 
			} 
			else if (acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("cadastro.jsp");
				request.setAttribute("candidatos", candDao.listar());
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String numero = request.getParameter("numero");

		Candidato cand = new Candidato();
		cand.setId(id != null && !id.isEmpty() ? Integer.parseInt(id) : null);
		cand.setNome(nome);
		cand.setNumero(numero);

		if (id == null || id.isEmpty()) {
			candDao.insert(cand);
		} else {
			candDao.update(cand);
		}

		try {
			RequestDispatcher view = request.getRequestDispatcher("cadastro.jsp");
			request.setAttribute("candidatos", candDao.listar());
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
