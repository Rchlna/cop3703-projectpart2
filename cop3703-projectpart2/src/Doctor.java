
public class Doctor {
	
	public Department associated;
	public Person person;
	public String id;
	public String address;
	public String phone;
	public String contact;
	
	public Doctor(Department associated, Person person, String id, String address, String phone, String contact) {
		this.associated = associated;
		String name = person.fullName;
		String ssn = person.socialSecurity;
		String dob = person.dateOfBirth;
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.contact = contact;		
	}

}
