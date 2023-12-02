import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProjectPart2 {

	public static Scanner scnr = new Scanner(System.in);
	public static String serverName = "cisvm-oracle.unfcsd.unf.edu";
	public static String portNumber = "1521";
	public static String sid = "orcl";
	public static String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	public static String username = "G01";
	public static String password = "r9Qi0oVD";

	public static void main(String[] args) throws SQLException {
		Connection connection = connect(); // Establishing database connection
		
		connection.setAutoCommit(false);
		
		while (true) {
			System.out.println("\nHospital Database");
			System.out.println("------------------------------");

			System.out.println("1. Add a new patient, department, procedures, doctors, medication, or interaction records.");
			System.out.println("2. Given a patient ID, generate their complete health record.");
			System.out.println("3. Given a department name or code find the procedures offered.");
			System.out.println("4. Given a doctor's ID list all the procedures they have done.");
			System.out.println("0. Exit");

			System.out.print("Enter your choice (0-6): ");
			int choice = scnr.nextInt();
			scnr.nextLine();

			switch (choice) {
			case 1: // Patient
				System.out.println("\nEnter New Hospital Information");
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

				switch (option1Choice) {
				case 1:

					System.out.println("\nPatient Information");
					System.out.println("------------------------------");

					System.out.println("Enter first name: ");
					String patientFirstName = scnr.nextLine();

					System.out.println("Enter middle initial: ");
					String patientMiddleInitial = scnr.nextLine();
//					scnr.nextLine();

					System.out.println("Enter last name: ");
					String patientLastName = scnr.nextLine();

					System.out.println("Enter date of birth: ");
					String patientDOB = scnr.nextLine();

					System.out.println("Enter SSN: ");
					String patientSSN = scnr.nextLine();
					
					char[] ssnArray = patientSSN.toCharArray();

					boolean SsnIsNumeric = true;
					for (int i = 0; i < ssnArray.length; i++) {
						if (i == 3 || i == 6) {
							if (ssnArray[i] != '-') {
								SsnIsNumeric = false;
								break;
							}
							SsnIsNumeric = true;
						}
						else {
							SsnIsNumeric = Character.isDigit(ssnArray[i]);
							if (!SsnIsNumeric) {
								SsnIsNumeric = false;
								break;
							}
							SsnIsNumeric = true;
						}
					}
					
					if (ssnArray.length != 11) {
						SsnIsNumeric = false;
					}
					
					while (!SsnIsNumeric) {
						System.out.println("Please enter SSN with the following format: AAA-GG-SSSS");
						System.out.println("Enter Patient SSN: ");
						patientSSN = scnr.nextLine();
						
						ssnArray = patientSSN.toCharArray();
						
						if (ssnArray.length != 11) {
							SsnIsNumeric = false;
							continue;
						}
						
						for (int i = 0; i < ssnArray.length; i++) {
							if (i == 3 || i == 6) {
								if (ssnArray[i] != '-') {
									SsnIsNumeric = false;
									break;
								}
								SsnIsNumeric = true;
							}
							else {
								SsnIsNumeric = Character.isDigit(ssnArray[i]);
								if (!SsnIsNumeric) {
									SsnIsNumeric = false;
									break;
								}
								SsnIsNumeric = true;
							}
						}
					}

					System.out.println("\nEnter patient sex:");
					char patientSex = scnr.next().charAt(0);
					scnr.nextLine();

					System.out.println("Enter patient ID: ");
					String patientId = scnr.nextLine();
					
					char[] ptIdArray = patientId.toCharArray();

					while (ptIdArray[0] != 'P' ||ptIdArray.length != 9) {
						System.out.println("Incorrect input, please provide the letter P followed by 8 numbers");
						System.out.println("Enter patient ID: ");
						
						patientId = scnr.nextLine();
						ptIdArray = patientId.toCharArray();
						
						boolean isNumeric = true;
						for (int i = 1; i < ptIdArray.length; i++) {
							isNumeric = Character.isDigit(ptIdArray[i]);
							if (!isNumeric) {
								break;
							}
						}
						if (!isNumeric) {
							continue;
						}
						
					}

					System.out.println("\nEnter patient current address:");
					String patientCurrAddr = scnr.nextLine();

					System.out.println("\nEnter patient current phone:");
					String patientCurrPhone = scnr.nextLine();

					patientCurrPhone = phoneValid(patientCurrPhone);

					System.out.println("\nEnter patient permanent street address:");
					String patientPermStreetAddr = scnr.nextLine();

					System.out.println("\nEnter patient permanent city: ");
					String patientPermCity = scnr.nextLine();

					System.out.println("\nEnter patient permanent state:");
					String patientPermState = scnr.nextLine();

					System.out.println("\nEnter patient permanent zipcode:");
					int patientPermZip = scnr.nextInt();
					scnr.nextLine();

					System.out.println("\nEnter patient permanent phone:");
					String patientPermPhone = scnr.nextLine();

					patientPermPhone = phoneValid(patientPermPhone);

					System.out.println("\nEnter patient condition (Critical, Stable, or Fair):");
					String patientCondition = scnr.nextLine();
					while (true) {
						if (patientCondition.equalsIgnoreCase("Critical")) {
							break;
						} else if (patientCondition.equalsIgnoreCase("Stable")) {
							break;
						} else if (patientCondition.equalsIgnoreCase("Fair")) {
							break;
						} else {
							System.out.println("\nEnter conditon Critical, Stable, or Fair:");
							System.out.println("\nEnter patient condition:");
							patientCondition = scnr.nextLine();
						}
					}

					System.out.println("\nEnter patient primary doctor ID:");
					String patientPrimaryDocID = scnr.nextLine();

					System.out.println("\nEnter patient secondary doctor ID (if any):");
					String patientSecondaryDocID = scnr.nextLine();

					// SQL insert statement for Patient
					Statement patientStmt = connection.createStatement();

					String patientValues = null;
					
					if (patientMiddleInitial.equals(null) && (!patientSecondaryDocID.equals(null))) {
						patientValues = " VALUES('" + patientSSN + "','" + patientFirstName + "','" + null + "','"
								+ patientLastName + "',TO_DATE('" + patientDOB + "','MM-DD-YYYY'),'" + patientId + "','"
								+ patientSex + "','" + patientCurrPhone + "','" + patientCurrAddr + "','"
								+ patientPermPhone + "','" + patientPermCity + "','" + patientPermState + "','"
								+ patientPermZip + "','" + patientCondition + "','" + patientPrimaryDocID + "','"
								+ patientSecondaryDocID + "')";

					} else if (patientSecondaryDocID.equals(null) && (!patientMiddleInitial.equals(null))) {
						patientValues = " VALUES('" + patientSSN + "','" + patientFirstName + "','"
								+ patientMiddleInitial + "','" + patientLastName + "',TO_DATE('" + patientDOB
								+ "','MM-DD-YYYY'),'" + patientId + "','" + patientSex + "','" + patientCurrPhone
								+ "','" + patientCurrAddr + "','" + patientPermPhone + "','" + patientPermCity + "','"
								+ patientPermState + "','" + patientPermZip + "','" + patientCondition + "','"
								+ patientPrimaryDocID + "'," + null + ")";

					} else if (patientMiddleInitial.equals(null) && (patientSecondaryDocID.equals(null))) {
						patientValues = " VALUES('" + patientSSN + "','" + patientFirstName + "'," + null + ",'"
								+ patientLastName + "',TO_DATE('" + patientDOB + "','MM-DD-YYYY'),'" + patientId + "','"
								+ patientSex + "','" + patientCurrPhone + "','" + patientCurrAddr + "','"
								+ patientPermPhone + "','" + patientPermCity + "','" + patientPermState + "','"
								+ patientPermZip + "','" + patientCondition + "','" + patientPrimaryDocID + "'," + null
								+ ")";

					} else {

						patientValues = " VALUES('" + patientSSN + "','" + patientFirstName + "','"
								+ patientMiddleInitial + "','" + patientLastName + "',TO_DATE('" + patientDOB
								+ "','MM-DD-YYYY'),'" + patientId + "','" + patientSex + "','" + patientCurrPhone
								+ "','" + patientCurrAddr + "','" + patientPermPhone + "','" + patientPermCity + "','"
								+ patientPermState + "','" + patientPermZip + "','" + patientCondition + "','"
								+ patientPrimaryDocID + "','" + patientSecondaryDocID + "')";
					}
					
					// SQL insert statement for Interaction Records
					Statement interationRecordNewPtStmt = connection.createStatement();
					
					LocalTime time = LocalTime.now();  
					DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm"); 					
			        String intRecTime = time.format(formatterTime).toString(); 
			        
			        LocalDate date = LocalDate.now();
			        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM-dd-YYYY");
			        String intRecDate = date.format(formatterDate).toString();

					String interationRecordNewPtValues = " VALUES('" + patientId + "','1','" + intRecTime + "', TO_DATE('" + intRecDate + "','MM-DD-YYYY'),'New patient admitted')";
					
					try {
						patientStmt.executeUpdate("INSERT INTO PATIENT" + patientValues);
						interationRecordNewPtStmt.executeUpdate("INSERT INTO INTERACTION_RECORD" + interationRecordNewPtValues);
					} catch (SQLException sqlE) {
						System.out.println(sqlE);
					} catch (Exception javaE) {
						System.out.println(javaE);
					}
				
					connection.commit();					

					break;
				case 2: // Department
					System.out.println("\nDepartment Information");
					System.out.println("------------------------------");

					System.out.println("Enter department name: ");
					String deptName = scnr.nextLine();

					System.out.println("Enter department code:");
					String deptCode = scnr.nextLine();
					
					System.out.println("Enter department office number:");
					String deptOfficeNumber = scnr.nextLine();
					
					while (deptOfficeNumber.length() != 4) {
						System.out.println("Department office number must be 4 characters in length");
						System.out.println("Enter department code:");
						deptOfficeNumber = scnr.nextLine();
					}

					System.out.println("Enter department phone number:");
					String deptOfficePhone = scnr.nextLine();

					deptOfficePhone = phoneValid(deptOfficePhone);

					System.out.println("\nEnter department head (Doctor ID):");
					String deptHead = scnr.nextLine();

					// SQL insert statement for Department
					Statement deptStmt = connection.createStatement();

					String deptValues = " VALUES('" + deptName + "','" + deptCode + "','" + deptOfficeNumber + "','"
							+ deptOfficePhone + "','" + deptHead + "')";

					try {
						deptStmt.executeUpdate("INSERT INTO DEPARTMENT" + deptValues);
					} catch (SQLException sqlE) {
						System.out.println(sqlE);
					} catch (Exception javaE) {
						System.out.println(javaE);
					}
					
					connection.commit();

					break;
				case 3: // Procedures
					System.out.println("\nProcedure Information");
					System.out.println("------------------------------");

					System.out.println("Enter procedure name: ");
					String procName = scnr.nextLine();
					
		
					String procNumber = null;
					char[] procNumArray = null;
					boolean whileContinue = false;
					while (true) {
						System.out.println("Enter procedure number: ");
						procNumber = scnr.nextLine();
						
						procNumArray = procNumber.toCharArray();

						if (procNumArray.length != 7) {
							System.out.println(
									"Enter procedure number with three letters followed by four digits");
							continue;
						}
						
						for (int i = 0; i < procNumArray.length; i++) {
							if (i >= 0 && i <= 2) {
								if (!Character.isAlphabetic(procNumArray[i])) {
									System.out.println(
											"Enter procedure number with three letters followed by four digits");
									whileContinue = true;
									break;
								}
							} else {
								if (!Character.isDigit(procNumArray[i])) {
									System.out.println(
											"Enter procedure number with three letters followed by four digits");
									whileContinue = true;
									break;
								}
							}
							whileContinue = false;
						}
						if (whileContinue) {
							continue;
						} else {
							break;
						}
					}
					

					System.out.println("Enter procedure duration: ");
					double procDuration = scnr.nextDouble();
					scnr.nextLine();

					System.out.println("Enter offering department code: ");
					String procCode = scnr.nextLine();

					System.out.println("Enter procedure description: ");
					String procDesc = scnr.nextLine();

					System.out.println("Enter Patient ID: ");
					String procPatientId = scnr.nextLine();

					System.out.println("Enter Doctor ID: ");
					String procDocId = scnr.nextLine();

					// SQL insert statement for Procedures
					Statement procStmt = connection.createStatement();

					String procValues = " VALUES('" + procName + "','" + procNumber + "','" + procDuration + "','"
							+ procDesc + "','" + procPatientId + "','" + procCode + "','" + procDocId + "')";
					
					
					Statement statementProc = connection.createStatement();

					// Patient Information
					ResultSet procPtIdRs = statementProc
							.executeQuery("select MAX(INTERACTION_RECORD.ID) from INTERACTION_RECORD WHERE INTERACTION_RECORD.PATIENT_ID = '"
									+ procPatientId + "'");
					int procPtId = 0;
					
					while (procPtIdRs.next()) {
						procPtId = procPtIdRs.getInt("MAX(INTERACTION_RECORD.ID)");
					}
					
					procPtId++;
					
					Statement interationRecordNewProcStmt = connection.createStatement();
					
					LocalTime timeProc = LocalTime.now();  
					DateTimeFormatter formatterTimeProc = DateTimeFormatter.ofPattern("HH:mm"); 					
			        String procTime = timeProc.format(formatterTimeProc).toString(); 
			        
			        LocalDate dateProc = LocalDate.now();
			        DateTimeFormatter formatterDateProc = DateTimeFormatter.ofPattern("MM-dd-YYYY");
			        String procDate = dateProc.format(formatterDateProc).toString();

					String interationRecordNewProcValues = " VALUES('" + procPatientId + "','"+ procPtId + " ','" + procTime + "', TO_DATE('" + procDate + "','MM-DD-YYYY'),'New procedure added')";
					
					
					try {
					procStmt.executeUpdate("INSERT INTO PROCEDURE" + procValues);
					interationRecordNewProcStmt.executeUpdate("INSERT INTO INTERACTION_RECORD" + interationRecordNewProcValues);

					} catch (SQLException sqlE) {
						System.out.println(sqlE);
					} catch (Exception javaE) {
						System.out.println(javaE);
					}
					
					connection.commit();

					break;
				case 4: // Doctors

					System.out.println("\nDoctor Information");
					System.out.println("------------------------------");

					System.out.println("Enter first name: ");
					String doctorFirstName = scnr.nextLine();

					System.out.println("Enter middle initial: ");
					char doctorMiddleInitial = scnr.next().charAt(0);
					scnr.nextLine();

					System.out.println("Enter last name: ");
					String doctorLastName = scnr.nextLine();

					System.out.println("Enter date of birth: ");
					String doctorDOB = scnr.nextLine();

					System.out.println("Enter SSN: ");
					String doctorSSN = scnr.nextLine();

					char[] dssnArray = doctorSSN.toCharArray();
					
					boolean dSsnIsNumeric = true;
					for (int i = 0; i < dssnArray.length; i++) {
						if (i == 3 || i == 6) {
							if (dssnArray[i] != '-') {
								dSsnIsNumeric = false;
								break;
							}
							dSsnIsNumeric = true;
						}
						else {
							dSsnIsNumeric = Character.isDigit(dssnArray[i]);
							if (!dSsnIsNumeric) {
								dSsnIsNumeric = false;
								break;
							}
							SsnIsNumeric = true;
						}
					}
					
					if (dssnArray.length != 11) {
						SsnIsNumeric = false;
					}
					
					while (!dSsnIsNumeric) {
						System.out.println("Please enter SSN with the following format: AAA-GG-SSSS");
						System.out.println("Enter Patient SSN: ");
						doctorSSN = scnr.nextLine();
						
						dssnArray = doctorSSN.toCharArray();

						for (int i = 0; i < dssnArray.length; i++) {
							if (i == 3 || i == 6) {
								if (dssnArray[i] != '-') {
									dSsnIsNumeric = false;
									break;
								}
								dSsnIsNumeric = true;
							}
							else {
								dSsnIsNumeric = Character.isDigit(dssnArray[i]);
								if (!dSsnIsNumeric) {
									SsnIsNumeric = false;
									break;
								}
								dSsnIsNumeric = true;
							}
						}
						
						if (dssnArray.length != 11) {
							SsnIsNumeric = false;
						}
					}

					System.out.println("Enter doctor ID: ");
					String doctorID = scnr.nextLine();
					
					char[] docIdArray = doctorID.toCharArray();

					while (docIdArray[0] != 'D' || docIdArray.length != 9) {
						System.out.println("Incorrect input, please provide the letter D followed by 8 numbers");
						System.out.println("Enter doctor ID: ");
						
						doctorID = scnr.nextLine();
						docIdArray = doctorID.toCharArray();
						
						boolean isNumeric = true;
						for (int i = 1; i < docIdArray.length; i++) {
							isNumeric = Character.isDigit(docIdArray[i]);
							if (!isNumeric) {
								break;
							}
						}
						if (!isNumeric) {
							continue;
						}
						
					}

					System.out.println("Enter address: ");
					String doctorAddr = scnr.nextLine();

					System.out.println("Enter doctor phone number: ");
					String doctorPhone = scnr.nextLine();

					doctorPhone = phoneValid(doctorPhone);

					System.out.println("Enter contact number: ");
					String doctorContact = scnr.nextLine();
					
					doctorContact = phoneValid(doctorContact);
					
					System.out.println("Enter the associated department code: ");
					String assocDeptCode = scnr.nextLine();
					
					Statement assocWithStmt = connection.createStatement();
					String assoWithValues = " VALUES('" + doctorID + "','" + assocDeptCode + "')";

					// SQL insert statement for Doctor
					Statement doctorStmt = connection.createStatement();

					String doctorValues = " VALUES('" + doctorSSN + "','" + doctorFirstName + "','" + doctorMiddleInitial
							+ "','" + doctorLastName + "',TO_DATE('" + doctorDOB + "','MM-DD-YYYY'),'" + doctorID + "','" + doctorAddr + "','"
							+ doctorPhone + "','" + doctorContact + "')";
					
					try {
					doctorStmt.executeUpdate("INSERT INTO DOCTOR" + doctorValues);
					assocWithStmt.executeUpdate("INSERT INTO ASSOCIATES_WITH" + assoWithValues);

					} catch (SQLException sqlE) {
						System.out.println(sqlE);
					} catch (Exception javaE) {
						System.out.println(javaE);
					}
					
					connection.commit();

					break;
				case 5: // Medications
					System.out.println("\nPrescription Information");
					System.out.println("------------------------------");

					System.out.println("Enter patient ID:");
					String rxPatient = scnr.nextLine();

					System.out.println("Enter prescribing doctor: ");
					String rxDoctor = scnr.nextLine();

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

					// SQL insert statement for Medications
					Statement rxStmt = connection.createStatement();

					String rxValues = " VALUES('" + rxName + "', TO_DATE('" + rxDate + "','MM-DD-YYYY'),'" + rxDesc + "','" + rxManufacturer
							+ "','" + rxDoctor + "','" + rxPatient + "')";
					
					
					Statement statementMed = connection.createStatement();

					// Patient Information
					ResultSet medPtIdRs = statementMed
							.executeQuery("select MAX(INTERACTION_RECORD.ID) from INTERACTION_RECORD WHERE INTERACTION_RECORD.PATIENT_ID = '"
									+ rxPatient + "'");
					int medPtId = 0;
					
					while (medPtIdRs.next()) {
						medPtId = medPtIdRs.getInt("MAX(INTERACTION_RECORD.ID)");
					}
					
					medPtId++;
					
					Statement interationRecordNewMedStmt = connection.createStatement();
					
					LocalTime timeMed = LocalTime.now();  
					DateTimeFormatter formatterTimeMed = DateTimeFormatter.ofPattern("HH:mm"); 					
			        String medTime = timeMed.format(formatterTimeMed).toString(); 
			        
			        LocalDate dateMed = LocalDate.now();
			        DateTimeFormatter formatterDateMed = DateTimeFormatter.ofPattern("MM-dd-YYYY");
			        String medDate = dateMed.format(formatterDateMed).toString();

					String interationRecordNewMedValues = " VALUES('" + rxPatient + "','"+ medPtId + " ','" + medTime + "', TO_DATE('" + medDate + "','MM-DD-YYYY'),'New medication prescribed')";
					
					try {
					rxStmt.executeUpdate("INSERT INTO MEDICATION" + rxValues);
					interationRecordNewMedStmt.executeUpdate("INSERT INTO INTERACTION_RECORD" + interationRecordNewMedValues);

					} catch (SQLException sqlE) {
						System.out.println(sqlE);
					} catch (Exception javaE) {
						System.out.println(javaE);
					}
				
					
					connection.commit();

					break;
				case 6: // Interaction Records
					System.out.println("\nInteraction Records");
					System.out.println("------------------------------");

					System.out.println("Enter patient ID: ");
					String interationRecordPatientId = scnr.nextLine();
					

					System.out.println("Enter description of interaction:");
					String interationRecordDesc = scnr.nextLine();

					// SQL insert statement for Interaction Records
					Statement interationRecordManualStmt = connection.createStatement();
					
					// Patient Information
					ResultSet interationRecordManualRs = interationRecordManualStmt
							.executeQuery("select MAX(INTERACTION_RECORD.ID) from INTERACTION_RECORD WHERE INTERACTION_RECORD.PATIENT_ID = '"
									+ interationRecordPatientId + "'");
					int genPtId = 0;
					
					while (interationRecordManualRs.next()) {
						genPtId = interationRecordManualRs.getInt("MAX(INTERACTION_RECORD.ID)");
					}
					
					genPtId++;
					
					
					LocalTime genMed = LocalTime.now();  
					DateTimeFormatter formatterTimeGen = DateTimeFormatter.ofPattern("HH:mm"); 					
			        String genTime = genMed.format(formatterTimeGen).toString(); 
			        
			        LocalDate dateGen = LocalDate.now();
			        DateTimeFormatter formatterDateGen = DateTimeFormatter.ofPattern("MM-dd-YYYY");
			        String genDate = dateGen.format(formatterDateGen).toString();

					String interationRecordGenValues = " VALUES('" + interationRecordPatientId + "','"+ genPtId + " ','" + genTime + "', TO_DATE('" + genDate + "','MM-DD-YYYY'),'"+ interationRecordDesc+"')";
					

					try {
						interationRecordManualStmt.executeUpdate("INSERT INTO INTERACTION_RECORD" + interationRecordGenValues);
					} catch (SQLException sqlE) {
						System.out.println(sqlE);
					} catch (Exception javaE) {
						System.out.println(javaE);
					}
					
					connection.commit();

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

				Statement statementA = connection.createStatement();

				// Patient Information
				ResultSet patientRs = statementA
						.executeQuery("select FIRST_NAME, MIDDLE_INITIAL, LAST_NAME, SSN, BIRTH_DATE, "
								+ "PATIENT_ID, SEX, CURR_PHONE, CURR_ADDRESS, PERM_PHONE, PERM_CITY, PERM_STATE, PERM_ZIP, CONDITION, PRIM_DOCTOR_ID, SEC_DOCTOR_ID, SSN"
								+ " from PATIENT" + " where PATIENT_ID = '" + searchPtId + "'");

				
				if (patientRs.next() == false) {
					System.out.println("Patient not found");
					break;
					
				} else {
				while (patientRs.next()) {						
					String patientId = patientRs.getString("PATIENT_ID");
					String firstName = patientRs.getString("FIRST_NAME");
					char midInitial = patientRs.getString("MIDDLE_INITIAL").charAt(0);
					String lastName = patientRs.getString("LAST_NAME");
					String currPhone = patientRs.getString("CURR_PHONE");
					String currAddr = patientRs.getString("CURR_ADDRESS");
					String primDoc = patientRs.getString("PRIM_DOCTOR_ID");

					System.out.printf("Patient ID: %s\n", patientId);
					System.out.printf("Name: %s %s %s\n", firstName, midInitial, lastName);
					System.out.printf("Current Phone: %s\n", currPhone);
					System.out.printf("Current Address: %s\n", currAddr);
					System.out.printf("Primary Doctor: %s\n", primDoc);
					}
				}

				// Procedures
				ResultSet procRs = statementA
						.executeQuery("select PROCEDURE.NAME from PROCEDURE where PATIENT_ID = '" + searchPtId + "'");

				System.out.println("\nProcedures Underwent: ");
				
				while (procRs.next()) {
					String procName = procRs.getString("NAME");
					System.out.println(procName);
				}

				// Interation Records
				
				ResultSet intRs = statementA.executeQuery(
						"select ITIME, DESCRIPTION from INTERACTION_RECORD where PATIENT_ID = '" + searchPtId + "'");

				System.out.println("\nInteraction Records");
				while (intRs.next()) {
					String time = intRs.getString("ITIME");
					String desc = intRs.getString("DESCRIPTION");

					System.out.printf("%s, %s\n", desc, time);
				}
				
				// Medications
				ResultSet medRs = statementA.executeQuery(
						"select MEDICATION.NAME, MEDICATION.DESCRIPTION, MEDICATION.PDATE from MEDICATION where PATIENT_ID = '" + searchPtId + "'");

				System.out.println("\nPrescribed Medications:");
				
				while (medRs.next()) {
					String name = medRs.getString("NAME");
					String desc = medRs.getString("DESCRIPTION");
					Date medDate = medRs.getDate("PDATE");

					System.out.printf("%s, %s, %s\n", name, desc, medDate);
				}
				connection.commit();

				break;
			case 3: // Query procedures offered by department
				System.out.println("Procedures Offered By Department ");
				System.out.println("------------------------------");
				System.out.println("1- for department name 2- for department code: ");
				String codeOrName = scnr.nextLine();
				boolean deptNameFlag = false;
				if (codeOrName.equals("1"))
					deptNameFlag = true;
				System.out.println("Department Name or Code:");
				String procDeptInput = scnr.nextLine();

				//boolean procDeptInput = true;

				Statement statementB = connection.createStatement();
				Statement statementD = connection.createStatement();

				ResultSet procDeptRs = null;
				ResultSet getDeptCode = null;				
				
				if (deptNameFlag == true) {
					getDeptCode = statementD.executeQuery(
							"select DEPARTMENT.CODE from DEPARTMENT where NAME = '" + procDeptInput + "'");

					String procCode = null;

					if (getDeptCode.next() == false) {
						System.out.println("Department not Found");
						break;
					} else {
						while (getDeptCode.next()) {
							procCode = getDeptCode.getString("CODE");
						}

						procDeptRs = statementB.executeQuery(
								"select PROCEDURE.NAME from PROCEDURE where PROCEDURE.CODE = '" + procCode + "'");
					}
				} else {
					procDeptRs = statementB.executeQuery(
							"select PROCEDURE.NAME from PROCEDURE where PROCEDURE.CODE = '" + procDeptInput + "'");
				}

				if (procDeptRs.next() == false) {
					System.out.println("Department not Found");
					break;
				} else {
					while (procDeptRs.next()) {
						String procName = procDeptRs.getString("NAME");
						System.out.println(procName);
					}
				}
				connection.commit();

				break;
			case 4: // Query doctor procedure history
				System.out.println("Doctor Procedure History");
				System.out.println("------------------------------");

				System.out.println("Doctor Name or ID:");
				String procDocInput = scnr.nextLine();

				boolean isDocId = true;

				Statement statementC = connection.createStatement();

				ResultSet procDocRs = null;
				if (procDocInput.charAt(0) == 'D' && procDocInput.length() == 9) {

					char[] charArr = procDocInput.toCharArray();

					for (int i = 1; i < charArr.length; i++) {
						if (!Character.isDigit(charArr[i])) {
							isDocId = false;
							break;
						}
					}
				}

				if (!isDocId) {
					procDocRs = statementC
							.executeQuery("select PROCEDURE.NAME from PROCEDURE where DOCTOR.NAME = '" + procDocInput + "'");
				} else {
					procDocRs = statementC.executeQuery(
							"select PROCEDURE.NAME from PROCEDURE join DOCTOR on DOCTOR.DOCTOR_ID = PROCEDURE.DOCTOR_ID where DOCTOR.DOCTOR_ID = '"
									+ procDocInput + "'");
				}

				if (procDocRs.next() == false) {
					System.out.println("Doctor not Found");
					break;
				} else {
				
				while (procDocRs.next()) {
					String procName = procDocRs.getString("NAME");
					System.out.println(procName);
				}
				
				connection.commit();
				}

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
	
	public static String phoneValid(String phone) {
		
		char[] phoneArray = phone.toCharArray();
		
		boolean phoneValid = true;
		for (int i = 0; i < phoneArray.length; i++) {
			if (i == 3 || i == 7) {
				if (phoneArray[i] != '-') {
					phoneValid = false;
					break;
				}
				phoneValid = true;
			}
			else {
				phoneValid = Character.isDigit(phoneArray[i]);
				if (!phoneValid) {
					phoneValid = false;
					break;
				}
				phoneValid = true;
			}
		}
		
		if (phoneArray.length != 12) {
			phoneValid = false;
		}
		
		while (!phoneValid) {
			System.out.println("Please enter phone number with the following format: XXX-XXX-XXXX");
			System.out.println("Enter phone number:");
			phone = scnr.nextLine();
			
			phoneArray = phone.toCharArray();

			for (int i = 0; i < phoneArray.length; i++) {
				if (i == 3 || i == 7) {
					if (phoneArray[i] != '-') {
						phoneValid = false;
						break;
					}
					phoneValid = true;
				}
				else { 
					phoneValid = Character.isDigit(phoneArray[i]);
					if (!phoneValid) {
					phoneValid = false;
					break;
					}
					phoneValid = true;
				}
			}
			
			if (phoneArray.length != 12) {
				phoneValid = false;
			}
		}
		
		return phone;
	}
} // end of project part 2