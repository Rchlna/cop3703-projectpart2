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

		System.out.println("Mr Potato Head");
		
		while (true) {
			System.out.println("Hospital Database Menu:");
			System.out.println(
					"1. Add a new patient, department, procedures, doctors, medication, or interaction records.");
			System.out.println("2. Add information about a procedure done on a patient.");
			System.out.println("3. Add medication/s prescribed to a patient.");
			System.out.println("4. Given a patient ID, generate their complete health record.");
			System.out.println("5. Given a department name or code find the procedures offered.");
			System.out.println("6. Given a doctor's ID list all the procedures they have done.");
			System.out.println("0. Exit");

			System.out.print("Enter your choice (0-6): ");
			int choice = scnr.nextInt();
			scnr.nextLine(); 

			switch (choice) {
			case 1: // Patient
				System.out.println("\n1. Add patient");
				System.out.println("2. Add department");
				System.out.println("3. Add procedures");
				System.out.println("4. Add doctors");
				System.out.println("5. Add medications");
				System.out.println("6. Add interaction records");

				System.out.print("Enter your choice (0-6): ");
				int option1Choice = scnr.nextInt();
				scnr.nextLine();

				// Might need to change to a loop.....
				switch (option1Choice) {
				case 1:
					System.out.println("\nEnter patient first name:");
					String ptFirstName = scnr.nextLine();

					System.out.println("\nEnter patient middle initial:");
					char ptMiddleInitial = scnr.next().charAt(0);
					scnr.nextLine();

					System.out.println("\nEnter patient last name:");
					String ptLastName = scnr.nextLine();

					System.out.println("\nEnter patient ID (P########):");
					String ptID = scnr.nextLine();

//					if (ptID.charAt(0) != 'P' || ptID.length() != 9) {
//						System.out.println("Invalid patient ID - format should start with 'P' followed by 8 digits. "
//								+ "Please try again.");
//						break;
//					}

					System.out.println("\nEnter patient SSN (###-##-####):");
					String ptSSN = scnr.nextLine();
					
					System.out.println("\nEnter patient current address:");
					String ptCurrAddr = scnr.nextLine();
					
					System.out.println("\nEnter patient current phone:");
					String ptCurrPhone = scnr.nextLine();
					
					System.out.println("\nEnter patient permanent street address:");
					String ptPermStreetAddr = scnr.nextLine();
					
					System.out.println("\nEnter patient permanent city, state, zip (Separate by comma):");
					String ptPermCityStZip = scnr.nextLine();
										
					System.out.println("\nEnter patient permanent phone:");
					String ptPermPhone = scnr.nextLine();
					
					System.out.println("\nEnter patient date of birth:");
					String ptDOB = scnr.nextLine();
					
					// On GUI, we could make this a dropdown selection with a user-enter option
					System.out.println("\nEnter patient sex:");
					char ptSex = scnr.next().charAt(0);
					scnr.nextLine();
					
					// On GUI, could make the following field some sort of selection (dropdown, checkboxes, radio buttons)
					System.out.println("\nEnter patient condition:");
					String ptCondition = scnr.nextLine();
					
//					System.out.println("\nEnter patient primary doctor:");
//					String patientPrimaryDocID = scnr.nextLine();
//					
//					System.out.println("\nEnter patient secondary doctor (if any):");
//					String patientSecondaryDocID = scnr.nextLine();
					
					System.out.println("Patient Information Entered");
					System.out.printf("Name: %s %c %s\n", ptFirstName, ptMiddleInitial, ptLastName);
					System.out.printf("ID: %s\n", ptID);
					System.out.printf("SSN: %s\n", ptSSN);
					System.out.printf("Date of Birth: %s	Sex: %c\n", ptDOB, ptSex);
					System.out.printf("Current Address: %s\nCurrent Phone: %s\n", ptCurrAddr, ptCurrPhone);
					System.out.printf("Permanent Address ID: %s, %s\nPermanent Phone: %s\n", ptPermStreetAddr, ptPermCityStZip, ptPermPhone);
					System.out.printf("Condition: %s\n\n", ptCondition);
					
					// Will need to add functionality for a 'Submit' button
					break;
				case 2:	// Department
					System.out.println("Enter department name: ");
					String deptName = scnr.nextLine();
					
					System.out.println("Enter department code:");
					String deptCode = scnr.nextLine();

					System.out.println("Enter department office number:");
					int deptOfficeNumber = scnr.nextInt();
					scnr.nextLine();
					
					System.out.println("Enter department phone number:");
					String deptOfficePhone = scnr.nextLine();

					System.out.println("Department Information Entered");
					System.out.printf("Name: %s\n", deptName);
					System.out.printf("Code: %s\n", deptCode);
					System.out.printf("Office Number: %d", deptOfficeNumber);
					System.out.printf("Office Phone: %s\n\n", deptOfficePhone);

					break;
				case 3: // Procedures
					System.out.println("Enter procedure name: ");
					String procName = scnr.nextLine();
					
					System.out.println("Enter procedure number: ");
					String procNumber = scnr.nextLine();

					System.out.println("Enter procedure duration: ");
					String procDuration = scnr.nextLine();
					
					System.out.println("Enter procedure description: ");
					String procDesc = scnr.nextLine();
					
					System.out.println("Procedure Information Enetered");
					System.out.printf("Name: %s\n", procName);
					System.out.printf("Number: %s\n", procNumber);
					System.out.printf("Duration: %s\n", procDuration);
					System.out.printf("Description: %s\n\n", procDesc);

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
