
public class Procedure {
	
	public String name;
	public String description;
	public String number;
	public double duration;
	public Department offeringDept;

	public Procedure(String name, String description, String number, double duration, Department offeringDept) {
		this.name = name;
		this.description = description;
		this.number = number;
		this.duration = duration;
		this.offeringDept = offeringDept;
	}

}
