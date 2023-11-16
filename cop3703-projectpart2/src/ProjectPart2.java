import java.sql.Connection;
import java.sql.DriverManager; // provide all necessary methods
import java.sql.SQLException;
import java.util.Scanner;

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
			Connection conn = DriverManager.getConnection(url, username, password); // creating a connection to db

			boolean reachable = conn.isValid(10); // 10 sec - checking if connection is valid

			if (reachable) {

				System.out.println("Successfully connected to Oracle Server\n");
				conn.close(); // closing connection
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner scnr = new Scanner(System.in);

		while (true) {
			System.out.println("Hospital Database Menu:");
			System.out
					.println("1. Add a new patient, department, procedures, doctors, medication, or interaction records.");
			System.out.println("2. Add information about a procedure done on a patient.");
			System.out.println("3. Add medication/s prescribed to a patient.");
			System.out.println("4. Given a patient ID, generate their complete health record.");
			System.out.println("5. Given a department name or code find the procedures offered.");
			System.out.println("6. Given a doctor's ID list all the procedures they have done.");
			System.out.println("0. Exit");

			System.out.print("Enter your choice (0-6): ");
			int choice = scnr.nextInt();
			scnr.nextLine(); // Consume the newline character
			switch (choice) {
			case 1:
				System.out.println("\n1. Add patient");
				System.out.println("2. Add department");
				System.out.println("3. Add procedures");
				System.out.println("4. Add doctors");
				System.out.println("5. Add medications");
				System.out.println("6. Add interaction records");

				System.out.println("Enter your choice (0-6):");
				int newChoice = scnr.nextInt();
				scnr.nextLine();
				
				switch(newChoice) {
				case 1:
					// Patient
					
					break;
				case 2:
					// Department
					
					break;
				case 3:
					// Procedures
					
					break;
				case 4:
					// Doctors
					
					break;
				case 5:
					// Medications
					
					break;
				case 6:
					// Interactions
					
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 0 and 6.");
				
				} // end of nested switch	
				break;
			case 2:
				// Insert stuff here for option 2
				break;
			case 3:
				// Insert stuff here for option 3
				break;
			case 4:
				// Insert stuff here for option 4
				break;
			case 5:
				// Insert stuff here for option 5
				break;
			case 6:
				// Insert stuff here for option 6
				break;
			case 0:
				System.out.println("Exiting the program. Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a number between 0 and 6.");
			}
			scnr.close();
		}
	}
}
