package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements Crud {
    private static Connection connection = MySqlConnection.createConnection();
    private static String sql;
   
    public static void create(Cliente cliente) {
        sql = "INSERT INTO clientes VALUES (null, ?,?,?,?, null, null, null, null, null, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setInt(3, cliente.getQtdConvidados());
            preparedStatement.setString(4, cliente.getSobremesa());
            cliente.verificarStatus();
            preparedStatement.setString(5, cliente.getStatus());
            
            preparedStatement.executeUpdate();

            System.out.println("Registro salvo corretamente.");
        }catch (SQLException e){

            System.out.println("Erro ao registror cliente." + e.getMessage());

        }
    }
    public static void delete(int clienteId) {
    	
    			sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    	
    };
    
    
    public static List<Cliente> find(String pesquisa){
        sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setQtdConvidados(resultSet.getInt("qtdConvidados"));
                cliente.setSobremesa(resultSet.getString("sobremesa"));
                cliente.setStatus(resultSet.getString("status"));
                clientes.add(cliente);

            }

            System.out.println("--correct find clientes");
            return clientes;

        } catch(SQLException e) {
            System.out.println("--incorrect find clientes. " + e.getMessage());
            return null;
        }

    }
    
    //TENTANDO CONSULTAR
    
    public static Cliente consultarCliente(String consultarFatura){
        sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%' ", consultarFatura);
        Cliente clienteFatura = new Cliente();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                clienteFatura.setNome(resultSet.getString("nome"));
                clienteFatura.setCpf(resultSet.getString("cpf"));
                

            }
            return null;

        } catch(SQLException e) {
            System.out.println("FILTROU ERRADO " + e.getMessage());
            return null;
        }

    }
    
    //FIM
    public static Cliente findByPk(String clienteId) {
    	
sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%' OR cpf LIKE '%s%%'", clienteId, clienteId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			
			
			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setQtdConvidados(resultSet.getInt("qtdConvidados"));
                cliente.setSobremesa(resultSet.getString("sobremesa"));
                cliente.setVrConvidados(resultSet.getDouble("vrConvidados"));
                cliente.setTxSobremesa(resultSet.getDouble("txSobremesa"));
                cliente.setQtdGarcoes(resultSet.getInt("qtdGarcoes"));
                cliente.setTxGarcoes(resultSet.getDouble("txGarcoes"));
                cliente.setVrTotal(resultSet.getDouble("vrTotal"));
                
			}
				cliente.calcVrTeste();
				cliente.getVrTeste();
				cliente.calcConvidados(cliente.getQtdConvidados());
				cliente.calcSobremesa();        
	            cliente.calcQtdGarcoes(cliente.getQtdConvidados());    
	            cliente.calcTaxGarcoes(cliente.getQtdGarcoes());
	            cliente.calcVrTotal();
	            cliente.verificarStatus();
			
			System.out.println("--correct find by pk clientes");
			return cliente;
			
	} catch(SQLException e) {
		
			System.out.println("--incorrect find by pk clientes. " + e.getMessage());
			return null;
		}    	  
    }
    
    
    public static void update(Cliente cliente) {
    	sql = "UPDATE clientes SET cpf=?, sobremesa=?, qtdConvidados=?, txGarcoes=?, vrConvidados=?, qtdGarcoes=?, txSobremesa=?, vrTotal=?, status=?  WHERE nome=?";

		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 	
			 	preparedStatement.setString(1, cliente.getCpf());
			 	preparedStatement.setString(2, cliente.getSobremesa());
				preparedStatement.setInt(3, cliente.getQtdConvidados());
				preparedStatement.setDouble(4, cliente.getTxGarcoes());
				preparedStatement.setDouble(5, cliente.getVrConvidados());
				preparedStatement.setInt(6, cliente.getQtdGarcoes());
				preparedStatement.setDouble(7, cliente.getTxSobremesa());
				preparedStatement.setDouble(8, cliente.getVrTotal());
				cliente.verificarStatus();
			 	preparedStatement.setString(9, cliente.getStatus());
			 	preparedStatement.setString(10, cliente.getNome());
			 	
			 	preparedStatement.executeUpdate();
		
			 System.out.println("--Contrato aceito com sucesso");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
    
    
    //FILTRA POR ID DADOS DO CLIENTE
    
    public static Cliente filtraPorId(int clienteId) {
    	
sql = String.format("SELECT * FROM clientes WHERE id = %d ", clienteId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setSobremesa(resultSet.getString("sobremesa"));
				cliente.setQtdConvidados(resultSet.getInt("qtdConvidados"));
				
			}
			
			System.out.println("--FILTRANDO POR ID");
			return cliente;
			
	} catch(SQLException e) {
		
			System.out.println("--incorrect find by pk clientes. " + e.getMessage());
			return null;
		}
	}
    
    //Visualizar proprosta no cliente
    
    public static Cliente filtraPorIdView(int clienteIdView) {
    	
    	sql = String.format("SELECT * FROM clientes WHERE id = %d ", clienteIdView);
    			
    			try {
    				Statement statement = connection.createStatement();
    				ResultSet resultSet = statement.executeQuery(sql);
    				Cliente cliente = new Cliente();
    				
    				while (resultSet.next()) {
    					cliente.setId(resultSet.getInt("id"));
    					cliente.setNome(resultSet.getString("nome"));
    					cliente.setCpf(resultSet.getString("cpf"));
    					cliente.setQtdConvidados(resultSet.getInt("qtdConvidados"));
    	                cliente.setSobremesa(resultSet.getString("sobremesa"));
    	                cliente.setVrConvidados(resultSet.getDouble("vrConvidados"));
    	                cliente.setTxSobremesa(resultSet.getDouble("txSobremesa"));
    	                cliente.setQtdGarcoes(resultSet.getInt("qtdGarcoes"));
    	                cliente.setTxGarcoes(resultSet.getDouble("txGarcoes"));
    	                cliente.setVrTotal(resultSet.getDouble("vrTotal"));
    					
    				}
    				
    				System.out.println("--FILTRANDO POR ID");
    				return cliente;
    				
    		} catch(SQLException e) {
    			
    				System.out.println("--incorrect find by pk clientes. " + e.getMessage());
    				return null;
    			}
    		}
    
    public static void updateCliente(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, cpf=?, sobremesa=?, qtdConvidados=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cliente.getNome());
			 preparedStatement.setString(2, cliente.getCpf());
			 preparedStatement.setString(3, cliente.getSobremesa());
			 preparedStatement.setInt(4, cliente.getQtdConvidados());
			 preparedStatement.setInt(5, cliente.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--CLIENTE ATUALIZADO COM SUCESSO");
			 
		 } catch(SQLException e) {
			 System.out.println("--ERRO AO ATUALIZAR CLIENTE. " + e.getMessage());
		 }catch (Exception e) {
			// TODO: handle exception
		}
	}
   

}

