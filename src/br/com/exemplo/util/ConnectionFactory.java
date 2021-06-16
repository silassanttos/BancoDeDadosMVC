package br.com.exemplo.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		try {
			// Realiza a comunicação com banco de dados.
			Class.forName("com.mysql.jdbc.Driver");
			// Constante para conexão
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3306/dbleitor";
			return DriverManager.getConnection(url,login,senha);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void main(String[] args){
		try {
			Connection conn = ConnectionFactory.getConnection();
			JOptionPane.showMessageDialog(null, "Conectado");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}	





	

