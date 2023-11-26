
public class Doctor {
	
	public Department associatedDept;
	public Person person;
	public String ssn;
	public String id;
	public String address;
	public String phone;
	public String contact;
	
	public Doctor(Person person, String id, String address, String phone, String contact) {
		this.ssn = person.socialSecurity;
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.contact = contact;		
	}

	public Department getAssociatedDept() {
		return associatedDept;
	}

	public void setAssociatedDept(Department associatedDept) {
		this.associatedDept = associatedDept;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
