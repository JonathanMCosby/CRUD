import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.Instant;

public class Update {

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
			final String query = "UPDATE actor SET first_name = ?, last_name = ?, last_update = ? "
					+ "WHERE  actor_id = ?";
			
			PreparedStatement prepStatement = myConnection.prepareStatement(query);
			
			prepStatement.setString(1, "Maary");
			prepStatement.setString(2, "Cruz");
			
			Timestamp timeNow = Timestamp.from(Instant.now());
			prepStatement.setString(3, timeNow.toString());
			
			prepStatement.setInt(4, 203);
			
			int result = prepStatement.executeUpdate();
			
			if (result == 1) {
				System.out.println("Update Successful");
			}
			else {
				System.out.println("Update not Successful");
			}
			
			
			
			//Make sure you close connection
			myConnection.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}