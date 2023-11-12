import java.sql.Connection;
import java.sql.DriverManager; 		// provide all necessary methods
import java.sql.SQLException;


public class ProjectPart2 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // loading database driver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String serverName = "cisvm-oracle.unfcsd.unf.edu";
        String portNumber = "1521";
        String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "G01";
        String password = "r9Qi0oVD";
        
        try {
			Connection conn = DriverManager.getConnection(url, username, password); //creating a connection to db
			
	        boolean reachable = conn.isValid(10); // 10 sec - checking if connection is valid

	        if(reachable) {
	        	
	        	System.out.println("Sucess");
	        	conn.close();		// closing connection
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
