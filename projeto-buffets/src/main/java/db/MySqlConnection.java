package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/projeto_buffets";
    private static final String user = "root";
    private static final String password = "";

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch(ClassNotFoundException e) {
            System.out.println("Driver não encontrado. " + e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            return connection;

        } catch(SQLException e) {
            System.out.println("Falha na conexão com o bd." + e.getMessage());
            return null;
        }
    }

}
