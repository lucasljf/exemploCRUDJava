package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static final String DSN = "jdbc:mysql://localhost/crudJava";
	private static final String USUARIO = "root";
	private static final String SENHA = "123456789";
	
	public Connection getConexao() {
		try {
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
