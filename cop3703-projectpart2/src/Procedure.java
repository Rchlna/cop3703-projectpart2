import java.util.*;

public class Procedure {
	
	public String name;
	public String description;
	public String number;
	public double duration;
	public Department offeringDept;
	public Patient patient;
	public ArrayList<Doctor> doctors;

	public Procedure(String name, String description, String number, double duration) {
		this.name = name;
		this.description = description;
		this.number = number;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Department getOfferingDept() {
		return offeringDept;
	}

	public void setOfferingDept(Department offeringDept) {
		this.offeringDept = offeringDept;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

}
