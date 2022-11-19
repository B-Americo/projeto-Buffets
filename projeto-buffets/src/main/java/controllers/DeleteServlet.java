package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

@WebServlet("/clienteDeletar")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		ClienteDao.delete(clienteId);
		
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
		
	}

}