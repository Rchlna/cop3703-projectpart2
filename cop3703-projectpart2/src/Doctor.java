
public class Doctor {
	
	public Person person;
	public String id;
	public String address;
	public String phone;
	public String contact;
	
	public Doctor(Person person, String id, String address, String phone, String contact) {
		String name = person.fullName;
		String ssn = person.socialSecurity;
		String dob = person.dateOfBirth;
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.contact = contact;		
	}

}
