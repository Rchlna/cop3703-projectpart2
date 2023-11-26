
public class Person {

	public String fullName;
	public String firstName;
	public char middleInitial;
	public String lastName;
	public String dateOfBirth;
	public String socialSecurity;
	
	public Person(String firstName, char middleInitial, String lastName, String dateOfBirth, String socialSecurity) {
		this.fullName = firstName + " " + middleInitial + " " + lastName;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.socialSecurity = socialSecurity;
	}
	
}
