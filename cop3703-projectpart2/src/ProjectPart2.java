import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class ProjectPart2 {

	public static Scanner scnr = new Scanner(System.in);
	public static String serverName = "cisvm-oracle.unfcsd.unf.edu";
	public static String portNumber = "1521";
	public static String sid = "orcl";
	public static String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	public static String username = "G01";
	public static String password = "r9Qi0oVD";

	public static void main(String[] args) throws SQLException{
		Connection connection = connect(); // Establishing database connection
	
		while (true) {
			System.out.println("Hospital Database");
			System.out.println("------------------------------");

			System.out.println(
					"1. Add a new patient, department, procedures, doctors, medication, or interaction records.");
//			System.out.println("2. Add information about a procedure done on a patient.");
//			System.out.println("2. Add medication/s prescribed to a patient.");
			System.out.println("2. Given a patient ID, generate their complete health record.");
			System.out.println("3. Given a department name or code find the procedures offered.");
			System.out.println("4. Given a doctor's ID list all the procedures they have done.");
			System.out.println("0. Exit");

			System.out.print("Enter your choice (0-6): ");
			int choice = scnr.nextInt();
			scnr.nextLine();

			switch (choice) {
			case 1: // Patient
				System.out.println("\nNew Information");
				System.out.println("------------------------------");
				System.out.println("1. Add patient");
				System.out.println("2. Add department");
				System.out.println("3. Add procedure");
				System.out.println("4. Add doctor");
				System.out.println("5. Add medication");
				System.out.println("6. Add interaction records");

				System.out.print("Enter your choice (0-6): ");
				int option1Choice = scnr.nextInt();
				scnr.nextLine();

				// Might need to change to a loop.....
				switch (option1Choice) {
				case 1:

					System.out.println("\nPatient Information");
					System.out.println("------------------------------");

					System.out.println("Enter first name: ");
					String patientFirstName = scnr.nextLine();

					System.out.println("Enter middle initial: ");
					char patientMiddleInitial = scnr.next().charAt(0);
					scnr.nextLine();

					System.out.println("Enter last name: ");
					String patientLastName = scnr.nextLine();

					System.out.println("Enter date of birth: ");
					String patientDOB = scnr.nextLine();

					System.out.println("Enter SSN: ");
					String patientSSN = scnr.nextLine();
					
					boolean SsnIsNumeric = true;
						for (int i = 0; i < patientSSN.length(); i++) {
							if (patientSSN.charAt(i) == 3 || patientSSN.charAt(i) == 6) {
								if (patientSSN.charAt(i) != '-') {
									SsnIsNumeric = false;
									break;
								}
								SsnIsNumeric = true;
							}
							SsnIsNumeric = Character.isDigit(patientSSN.charAt(i));
							if (!SsnIsNumeric) {
								SsnIsNumeric = false;
								break;
							}
							SsnIsNumeric = true;
						}
					while (!SsnIsNumeric) {
						System.out.println("Please enter SSN with thte following format: AAA-GG-SSSS");
						System.out.println("Enter Patient SSN: ");
						patientSSN = scnr.nextLine();
						
						for (int i = 0; i < patientSSN.length(); i++) {
							if (patientSSN.charAt(i) == 3 || patientSSN.charAt(i) == 6) {
								if (patientSSN.charAt(i) != '-') {
									SsnIsNumeric = false;
									break;
								}
								SsnIsNumeric = true;
							}
							SsnIsNumeric = Character.isDigit(patientSSN.charAt(i));
							if (!SsnIsNumeric) {
								SsnIsNumeric = false;
								break;
							}
							SsnIsNumeric = true;
						}
					}
					
					//Person pPersonInfo = personInput();

					// On GUI, we could make this a dropdown selection with a user-enter option
					System.out.println("\nEnter patient sex:");
					char ptSex = scnr.next().charAt(0);
					scnr.nextLine();

					System.out.println("Enter patient ID: ");
					String ptId = scnr.nextLine();
					
					while (ptId.charAt(0) != 'P' || ptId.length() != 9) {
						System.out.println("Incorrect input, please provide the letter P followed by 8 numbers");
						System.out.println("Enter patient ID: ");
						boolean isNumeric = true;
						for (int i = 1; i < ptId.length(); i++) {
							isNumeric = Character.isDigit(ptId.charAt(i));
							if (!isNumeric) {
								break;
							}
						}
						if (!isNumeric) {
							continue;
						}
						ptId = scnr.nextLine(); 
					}

					System.out.println("\nEnter patient current address:");
					String ptCurrAddr = scnr.nextLine();

					System.out.println("\nEnter patient current phone:");
					String ptCurrPhone = scnr.nextLine();
					
					boolean phoneValid = true;
					for (int i = 0; i < ptCurrPhone.length(); i++) {
						if (ptCurrPhone.charAt(i) == 3 || ptCurrPhone.charAt(i) == 7) {
							if (ptCurrPhone.charAt(i) != '-') {
								phoneValid = false;
								break;
							}
							phoneValid = true;
						}
						phoneValid = Character.isDigit(ptCurrPhone.charAt(i));
						if (!phoneValid) {
							phoneValid = false;
							break;
						}
						phoneValid = true;
					}
				while (!phoneValid) {
					System.out.println("Please enter phone number with the following format: XXX-XXX-XXXX");
					System.out.println("Enter patient current phone:");
					ptCurrPhone = scnr.nextLine();
					
					for (int i = 0; i < ptCurrPhone.length(); i++) {
						if (ptCurrPhone.charAt(i) == 3 || ptCurrPhone.charAt(i) == 6) {
							if (ptCurrPhone.charAt(i) != '-') {
								phoneValid = false;
								break;
							}
							phoneValid = true;
						}
						phoneValid = Character.isDigit(ptCurrPhone.charAt(i));
						if (!phoneValid) {
							phoneValid = false;
							break;
						}
						phoneValid = true;
					}
				}

					System.out.println("\nEnter patient permanent street address:");
					String ptPermStreetAddr = scnr.nextLine();

					System.out.println("\nEnter patient permanent city: ");
					String ptPermCity = scnr.nextLine();

					System.out.println("\nEnter patient permanent state:");
					String ptPermState = scnr.nextLine();

					System.out.println("\nEnter patient permanent zipcode:");
					int ptPermZip = scnr.nextInt();
					scnr.nextLine();

					System.out.println("\nEnter patient permanent phone:");
					String ptPermPhone = scnr.nextLine();
					
					phoneValid = true;
					for (int i = 0; i < ptPermPhone.length(); i++) {
						if (ptCurrPhone.charAt(i) == 3 || ptPermPhone.charAt(i) == 7) {
							if (ptPermPhone.charAt(i) != '-') {
								phoneValid = false;
								break;
							}
							phoneValid = true;
						}
						phoneValid = Character.isDigit(ptPermPhone.charAt(i));
						if (!phoneValid) {
							phoneValid = false;
							break;
						}
						phoneValid = true;
					}
				while (!phoneValid) {
					System.out.println("Please enter phone number with the following format: XXX-XXX-XXXX");
					System.out.println("Enter patient current phone:");
					ptPermPhone = scnr.nextLine();
					
					for (int i = 0; i < ptPermPhone.length(); i++) {
						if (ptPermPhone.charAt(i) == 3 || ptPermPhone.charAt(i) == 6) {
							if (ptPermPhone.charAt(i) != '-') {
								phoneValid = false;
								break;
							}
							phoneValid = true;
						}
						phoneValid = Character.isDigit(ptPermPhone.charAt(i));
						if (!phoneValid) {
							phoneValid = false;
							break;
						}
						phoneValid = true;
					}
				}

					// On GUI, could make the following field some sort of selection (dropdown,
					// checkboxes, radio buttons)
					System.out.println("\nEnter patient condition:");
					String ptCondition = scnr.nextLine();

					System.out.println("\nEnter patient primary doctor ID:");
					String patientPrimaryDocID = scnr.nextLine();

					System.out.println("\nEnter patient secondary doctor ID (if any):");
					String patientSecondaryDocID = scnr.nextLine();

					/*Patient patient = new Patient(pPersonI ptId, ptSex, ptCurrPhone, ptPermPhone, ptCurrAddr,
							ptPermStreetAddr, ptPermCity, ptPermState, ptPermZip, ptCondition, patientPrimaryDocID);

					patient.setPrimary(patientPrimaryDocID);
					

					if (patientSecondaryDocID != null) {
						patient.setSecondary(patientSecondaryDocID);
					}
					*/

					// Will need to add functionality for a 'Submit' button
					break;
				case 2: // Department
					System.out.println("\nDepartment Information");
					System.out.println("------------------------------");

					System.out.println("Enter department name: ");
					String deptName = scnr.nextLine();

					System.out.println("Enter department code:");
					String deptCode = scnr.nextLine();

					System.out.println("Enter department office number:");
					int deptOfficeNumber = scnr.nextInt();
					scnr.nextLine();

					System.out.println("Enter department phone number:");
					String deptOfficePhone = scnr.nextLine();

					System.out.println("\nEnter department head:");
					String deptHead = scnr.nextLine();

					Department dept = new Department(deptName, deptCode, deptOfficeNumber, deptOfficePhone, deptHead);

					break;
				case 3: // Procedures
					System.out.println("\nProcedure Information");
					System.out.println("------------------------------");

					System.out.println("Enter procedure name: ");
					String procName = scnr.nextLine();

					System.out.println("Enter procedure number: ");
					String procNumber = scnr.nextLine();

					System.out.println("Enter procedure duration: ");
					double procDuration = scnr.nextDouble();
					scnr.nextLine();

					System.out.println("Enter procedure description: ");
					String procDesc = scnr.nextLine();

					Procedure proc = new Procedure(procName, procDesc, procNumber, procDuration);

					break;
				case 4: // Doctors
					
					System.out.println("Enter first name: ");
					String docFirstName = scnr.nextLine();

					System.out.println("Enter middle initial: ");
					char docMiddleInitial = scnr.next().charAt(0);
					scnr.nextLine();

					System.out.println("Enter last name: ");
					String docLastName = scnr.nextLine();

					System.out.println("Enter date of birth: ");
					String docDOB = scnr.nextLine();

					System.out.println("Enter SSN: ");
					String docSSN = scnr.nextLine();
					
					boolean dSsnIsNumeric = true;
					for (int i = 0; i < docSSN.length(); i++) {
						if (docSSN.charAt(i) == 3 || docSSN.charAt(i) == 6) {
							if (docSSN.charAt(i) != '-') {
								dSsnIsNumeric = false;
								break;
							}
							dSsnIsNumeric = true;
						}
						dSsnIsNumeric = Character.isDigit(docSSN.charAt(i));
						if (!SsnIsNumeric) {
							dSsnIsNumeric = false;
							break;
						}
						SsnIsNumeric = true;
					}
				while (!SsnIsNumeric) {
					System.out.println("Please enter SSN with thte following format: AAA-GG-SSSS");
					System.out.println("Enter Patient SSN: ");
					docSSN = scnr.nextLine();
					
					for (int i = 0; i < docSSN.length(); i++) {
						if (docSSN.charAt(i) == 3 || docSSN.charAt(i) == 6) {
							if (docSSN.charAt(i) != '-') {
								dSsnIsNumeric = false;
								break;
							}
							dSsnIsNumeric = true;
						}
						dSsnIsNumeric = Character.isDigit(docSSN.charAt(i));
						if (!SsnIsNumeric) {
							SsnIsNumeric = false;
							break;
						}
						dSsnIsNumeric = true;
					}
				}
					
					System.out.println("\nDoctor Information");
					System.out.println("------------------------------");

					//Person dPersonInfo = personInput();

					System.out.println("Enter doctor ID: ");
					String docID = scnr.nextLine();
					
					while (docID.charAt(0) != 'D' || docID.length() != 9) {
						System.out.println("Incorrect input, please provide the letter D followed by 8 numbers");
						System.out.println("Enter doctor ID: ");
						boolean isNumeric = true;
						for (int i = 1; i < docID.length(); i++) {
							isNumeric = Character.isDigit(docID.charAt(i));
							if (!isNumeric) {
								break;
							}
						}
						if (!isNumeric) {
							continue;
						}
						docID = scnr.nextLine(); 
					}

					System.out.println("Enter address: ");
					String docAddr = scnr.nextLine();

					System.out.println("Enter phone number: ");
					String docPhone = scnr.nextLine();
					
					phoneValid = true;
					for (int i = 0; i < docPhone.length(); i++) {
						if (docPhone.charAt(i) == 3 || docPhone.charAt(i) == 7) {
							if (docPhone.charAt(i) != '-') {
								phoneValid = false;
								break;
							}
							phoneValid = true;
						}
						phoneValid = Character.isDigit(docPhone.charAt(i));
						if (!phoneValid) {
							phoneValid = false;
							break;
						}
						phoneValid = true;
					}
					while (!phoneValid) {
						System.out.println("Please enter phone number with the following format: XXX-XXX-XXXX");
						System.out.println("Enter patient current phone:");
						docPhone = scnr.nextLine();

						for (int i = 0; i < docPhone.length(); i++) {
							if (docPhone.charAt(i) == 3 || docPhone.charAt(i) == 6) {
								if (docPhone.charAt(i) != '-') {
									phoneValid = false;
									break;
								}
								phoneValid = true;
							}
							phoneValid = Character.isDigit(docPhone.charAt(i));
							if (!phoneValid) {
								phoneValid = false;
								break;
							}
							phoneValid = true;
						}
					}

					System.out.println("Enter contact number: ");
					String docContact = scnr.nextLine();

					//Doctor doc = new Doctor(dPersonInfo, docID, docAddr, docPhone, docContact);

					break;
				case 5: // Medications
					System.out.println("\nPrescription Information");
					System.out.println("------------------------------");

					System.out.println("Enter patient ID:");
					String rxPatient = scnr.nextLine();
					// figure out how to link to patient table

					System.out.println("Enter prescribing doctor: ");
					String rxDoctor = scnr.nextLine();
					// figure out how to link to the doctor table

					System.out.println("Enter prescription date: ");
					String rxDate = scnr.nextLine();

					System.out.println("\nMedication Information");
					System.out.println("------------------------------");

					System.out.println("Enter medication name: ");
					String rxName = scnr.nextLine();

					System.out.println("Enter medication manufacturer: ");
					String rxManufacturer = scnr.nextLine();

					System.out.println("Enter medication description: ");
					String rxDesc = scnr.nextLine();

//					Medication medication = new Medication(rxDate, rxName, rxManufacturer, rxDesc);

					break;
				case 6: // Interactions

					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 0 and 6.");

				} // end of nested switch
				break;
			case 2: // Query patient health record
				System.out.println("Patient Health Record Search");
				System.out.println("------------------------------");

				System.out.println("Patient ID:");
				String searchPtId = scnr.nextLine();

				Statement statement = connection.createStatement();
				
				ResultSet resultSet = statement.executeQuery("select FIRST NAME, MIDDLE INITIAL, LAST NAME, SSN, BIRTH DATE, "
						+ "PATIENT ID, SEX, CURR PHONE, CURR ADDRESS, PERM PHONE, PERM CITY, PERM STATE, PERM ZIP, CONDITION, PRIM DOCTOR ID, SEC DOCTOR ID, SSN"
						+ "from PATIENT"
						+ "where PATIENT ID = '" + searchPtId + "'");
				
				while (resultSet.next()) {
					String patientId = resultSet.getString("PATIENT ID");
					String firstName = resultSet.getString("FIRST NAME");
					char midInitial = resultSet.getString("MIDDLE INITIAL").charAt(0);
					String lastName = resultSet.getString("LAST NAME");
					int currPhone = resultSet.getInt("CURR PHONE");
					String currAddr = resultSet.getString("CURR ADDRESS");
					String primDoc = resultSet.getString("PRIM DOCTOR ID");					
					
				}

				break;
			case 3: // Query procedures offered by department

				break;
			case 4: // Query doctor procedure history

				break;

			case 0:
				System.out.println("Exiting the program. Goodbye!");
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please enter a number between 0 and 4.");
			}
			scnr.close();
		}
	} // end of main

	// Creates a connection to Oracle Server
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	// Prompts user for Person information as input
	// Returns Person object
	public static Person personInput() {
		System.out.println("Enter first name: ");
		String personFirstName = scnr.nextLine();

		System.out.println("Enter middle initial: ");
		char personMiddleInitial = scnr.next().charAt(0);
		scnr.nextLine();

		System.out.println("Enter last name: ");
		String personLastName = scnr.nextLine();

		System.out.println("Enter date of birth: ");
		String personDOB = scnr.nextLine();

		System.out.println("Enter SSN: ");
		String personSSN = scnr.nextLine();

		Person person = new Person(personFirstName, personMiddleInitial, personLastName, personDOB, personSSN);

		return person;

	}
} // end of project part 2
