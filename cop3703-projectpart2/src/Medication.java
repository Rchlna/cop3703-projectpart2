
public class Medication {
	
	public Patient patient;
	public Doctor prescriber;
	public String prescriptionDate;
	public String name;
	public String manufacturer;
	public String description;

	public Medication(Patient patient, Doctor prescriber, String prescriptionDate, String name, String manufacturer, String description) {
		this.patient = patient;
		this.prescriber = prescriber;
		this.prescriptionDate = prescriptionDate;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getPrescriber() {
		return prescriber;
	}

	public void setPrescriber(Doctor prescriber) {
		this.prescriber = prescriber;
	}

	public String getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(String prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
