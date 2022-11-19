package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

import model.Cliente;


@WebServlet("/FaturaAndFind")
public class FaturaCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FaturaCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String consulta = request.getParameter("consulta");	
			
			if (consulta == null){
				consulta = "";
	        
			}
			
			Cliente cliente = ClienteDao.findByPk(consulta);
			
			
			request.setAttribute("cliente", cliente);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("fatura.jsp");
			requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			Cliente cliente = new Cliente();  
		
	
			cliente.setNome(request.getParameter("nome"));
	        cliente.setCpf(request.getParameter("cpf"));
	        cliente.setSobremesa(request.getParameter("sobremesa"));
	        int qtdConvidados = Integer.parseInt(request.getParameter("qtdConvidados"));       
	        cliente.setQtdConvidados(qtdConvidados);
	        cliente.setQtdGarcoes(Integer.parseInt(request.getParameter("qtdGarcoes")));
	        cliente.setTxGarcoes(Double.parseDouble(request.getParameter("txGarcoes")));
	        cliente.setVrConvidados(Double.parseDouble(request.getParameter("vrConvidados")));
	        cliente.setTxSobremesa(Double.parseDouble(request.getParameter("txSobremesa")));
	        cliente.setVrTotal(Double.parseDouble(request.getParameter("vrTotal")));
	       // cliente.verificarStatus(); // TEste
	        
	       // String vrConvidados = (request.getParameter("vrConvidados"));
	        //Double teste = Double.parseDouble(vrConvidados);
	       // System.out.println("TES/TANDO vrConvidados:  " + vrConvidados);
	       // cliente.setVrConvidados(vrConvidados);
	        
	        //cliente.setVrConvidados(Double.parseDouble(request.getParameter("vrConvidados")));
			/*
			 * try { System.out.println("Deu certo" + cliente.getQtdConvidados());
			 * cliente.setQtdConvidados(Integer.parseInt(request.getParameter(
			 * "qtdConvidados")));
			 * 
			 * cliente.setSobremesa(request.getParameter("sobremesa"));
			 * 
			 * cliente.setTxSobremesa(Double.parseDouble(request.getParameter("txSobremesa")
			 * ));
			 * cliente.setQtdGarcoes(Integer.parseInt(request.getParameter("qtdGarçoes")));
			 * cliente.setTxGarcoes(Double.parseDouble(request.getParameter("txGarcoes")));
			 * cliente.setVrTotal(Double.parseDouble(request.getParameter("vrTotal")));
			 * 
			 * } catch (NumberFormatException e) { System.err.println(
			 * "String inválida no argumento" + e ); }
			 */
	   
	        
	       ClienteDao.update(cliente);
	        
	        
	       ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);

	}
	
	
	
	
	
	
	
	

}