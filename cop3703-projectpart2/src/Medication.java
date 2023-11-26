
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

}
