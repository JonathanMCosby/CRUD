import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.Instant;

public class Create {

	public static void main(String[] args) {
		// database location server
		final String database = "jdbc:mysql:///sakila";
		
		// username
		final String username = "root";
		
		// password
		final String password = "Kteasley";
		
		try {
			Connection myConnection = DriverManager.getConnection(database, username, password);
			System.out.println("Connection Successful");
			
			//Execute queries 
			
			//Prepare query
			final String query = "INSERT INTO actor (first_name, last_name, last_update) "
					+ "VALUES (?,?,?)";
			
			//Prepare query for database
			PreparedStatement prepStatement = myConnection.prepareStatement(query);
			
			// provide value
			prepStatement.setString(1, "Bob");
			prepStatement.setString(2, "Roland");
			
			Timestamp timeNow = Timestamp.from(Instant.now());
			prepStatement.setString(3, timeNow.toString());
			
			int result = prepStatement.executeUpdate();
			System.out.println(result);
			
			if (result == 1) {
				System.out.println("Actor added successfully");
			}
			else {
				System.out.println("Unsuccessful");
			}
			//Make sure you close connection
			myConnection.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}