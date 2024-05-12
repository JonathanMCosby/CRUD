import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Read {

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
			final String query = "SELECT * FROM actor";
			
			Statement statement = myConnection.createStatement();
			
			//create the result set object
			ResultSet result = statement.executeQuery(query);
			
			//display content of the result set
			while(result.next()) {
				System.out.println(result.getString(2)+ "\t"+result.getString(3));
			}
			
			//Make sure you close connection
			myConnection.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
