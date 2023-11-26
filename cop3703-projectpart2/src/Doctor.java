
public class Doctor {
	
	public Department associatedDept;
	public Person person;
	public String ssn;
	public String id;
	public String address;
	public String phone;
	public String contact;
	
	public Doctor(Department associatedDept, Person person, String id, String address, String phone, String contact) {
		this.associatedDept = associatedDept;
		this.ssn = person.socialSecurity;
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.contact = contact;		
	}

}
