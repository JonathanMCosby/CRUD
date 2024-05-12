import java.sql.*;
import java.sql.DriverManager;
public class TestConnection {

	public static void main(String[] args) {
		// database location server
		final String database = "jdbc:mysql:///sakila";
		
		// username
		final String username = "root";
		
		// password
		final String password = "Password";
		
		try {
			Connection myConnection = DriverManager.getConnection(database, username, password);
			System.out.println("Connection Successful");
			
			//Execute queries 
			
			
			//Make sure you close connection
			myConnection.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
