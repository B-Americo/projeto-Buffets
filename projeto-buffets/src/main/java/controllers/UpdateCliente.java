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

@WebServlet("/clienteAtualizar")
public class UpdateCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCliente() {
		super();

	}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		Cliente cliente = ClienteDao.filtraPorId(clienteId);
		
		request.setAttribute("cliente", cliente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setQtdConvidados(Integer.parseInt(request.getParameter("qtdConvidados")));
		cliente.setSobremesa(request.getParameter("sobremesa"));
		
		ClienteDao.updateCliente(cliente);
		
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
	}

}