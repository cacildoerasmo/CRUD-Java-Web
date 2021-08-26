package crud.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.dao.TurmaDAO;
import crud.model.Turma;


@WebServlet(urlPatterns={"/new1","/insert1","/delete1","/edit1","/update1","/list1"})
public class TurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TurmaDAO turmaDAO;
	
	public void init() {
		turmaDAO = new TurmaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new1":
				showNewForm(request, response);
				break;
			case "/insert1":
				insertTurma(request, response);
				break;
			case "/delete1":
				deleteTurma(request, response);
				break;
			case "/edit1":
				showEditForm(request, response);
				break;
			case "/update1":
				updateTurma(request, response);
				break;
			default:
				listTurma(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listTurma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Turma> listTurma = turmaDAO.getAllTurma();
		request.setAttribute("listTurma", listTurma);
		RequestDispatcher dispatcher = request.getRequestDispatcher("turma-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("turma-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int identificacao = Integer.parseInt(request.getParameter("identificacao"));
		Turma existingTurma = turmaDAO.getTurma(identificacao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("turma-form.jsp");
		request.setAttribute("turma", existingTurma);
		dispatcher.forward(request, response);

	}

	private void insertTurma(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String descricao = request.getParameter("descricao");
		Turma newTurma = new Turma(descricao);
		turmaDAO.saveTurma(newTurma);
		response.sendRedirect("list1");
	}

	private void updateTurma(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int identificacao = Integer.parseInt(request.getParameter("identificacao"));
		String descricao = request.getParameter("descricao");

		Turma turma = new Turma(identificacao, descricao);
		turmaDAO.updateTurma(turma);

		response.sendRedirect("list1");
	}

	private void deleteTurma(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int identificacao = Integer.parseInt(request.getParameter("identificacao"));
		turmaDAO.deleteTurma(identificacao);
		
		
		response.sendRedirect("list1");
		

	}



}

