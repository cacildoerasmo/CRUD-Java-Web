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

import crud.dao.EstudanteDAO;
import crud.model.Estudante;

@WebServlet("/")
public class EstudanteServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		private EstudanteDAO estudanteDAO;
		
		public void init() {
			estudanteDAO = new EstudanteDAO();
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
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertEstudante(request, response);
					break;
				case "/delete":
					deleteEstudante(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateEstudante(request, response);
					break;
				default:
					listEstudante(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}

		private void listEstudante(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Estudante> listEstudante = estudanteDAO.getAllEstudante();
			request.setAttribute("listEstudante", listEstudante);
			RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-list.jsp");
			dispatcher.forward(request, response);
		}

		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-form.jsp");
			dispatcher.forward(request, response);
		}

		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int numero_matricula = Integer.parseInt(request.getParameter("numero_matricula"));
			Estudante existingEstudante = estudanteDAO.getEstudante(numero_matricula);
			RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-form.jsp");
			request.setAttribute("estudante", existingEstudante);
			dispatcher.forward(request, response);

		}

		private void insertEstudante(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int fk_identificacao_turma = Integer.parseInt(request.getParameter("fk_identificacao_turma"));
			String nome = request.getParameter("nome");
			String apelido = request.getParameter("apelido");
			int telefone = Integer.parseInt(request.getParameter("telefone"));
			String endereco = request.getParameter("endereco");
			Estudante newEstudante = new Estudante(fk_identificacao_turma, nome, apelido, telefone, endereco);
			estudanteDAO.saveEstudante(newEstudante);
			response.sendRedirect("list");
		}

		private void updateEstudante(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int numero_matricula = Integer.parseInt(request.getParameter("numero_matricula"));
			int fk_identificacao_turma = Integer.parseInt(request.getParameter("fk_identificacao_turma"));
			String nome = request.getParameter("nome");
			String apelido = request.getParameter("apelido");
			int telefone = Integer.parseInt(request.getParameter("telefone"));
			String endereco = request.getParameter("endereco");

			Estudante estudante = new Estudante(numero_matricula,fk_identificacao_turma, nome, apelido, telefone, endereco);
			estudanteDAO.updateEstudante(estudante);
	
			response.sendRedirect("list");
		}

		private void deleteEstudante(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int numero_matricula = Integer.parseInt(request.getParameter("numero_matricula"));
			estudanteDAO.deleteEstudante(numero_matricula);
			
			response.sendRedirect("list");
			

		}
	
	

}
