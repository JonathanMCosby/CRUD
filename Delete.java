import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Delete {

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
			final String query = "DELETE FROM actor WHERE actor_id = ?";
			
			PreparedStatement preStatement = myConnection.prepareStatement(query);
			
			preStatement.setInt(1,203);
			
			int result = preStatement.executeUpdate();
			
			if(result == 1) {
				System.out.println("Successfully Deleted");
			}
			else {
				System.out.println("Could not Deleted");
			}
			
			//Make sure you close connection
			myConnection.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
