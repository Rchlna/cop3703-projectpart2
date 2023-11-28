import java.util.*;

public class Patient {

	public Person person;
	public String ssn;
	public String id;
	public char sex;
	public String currentPhone;
	public String currentAddress;
	public String permanentPhone;
	public String permanentAddress;
	public String permanentStreet;
	public String permanentCity;
	public String permanentState;
	public int permanentZipcode;
	public String condition;
	public String primary;
	public String secondary;
	public ArrayList<Procedure> procedures;
	
	public Patient(Person person, String id, char sex, String currentPhone, String currentAddress, String permanentPhone, 
			String permanentStreet, String permanentCity, String permanentState, int permanentZipcode){
		this.ssn = person.socialSecurity;
		this.id = id;
		this.sex = sex;
		this.currentPhone = currentPhone;
		this.currentAddress = currentAddress;
		this.permanentPhone = permanentPhone;
		this.permanentAddress = permanentStreet + ", " + permanentCity + ", " + permanentState + ", " + permanentZipcode;
		this.permanentStreet = permanentStreet;
		this.permanentCity = permanentCity;
		this.permanentState = permanentStreet;
		this.permanentZipcode = permanentZipcode;	
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getCurrentPhone() {
		return currentPhone;
	}

	public void setCurrentPhone(String currentPhone) {
		this.currentPhone = currentPhone;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentPhone() {
		return permanentPhone;
	}

	public void setPermanentPhone(String permanentPhone) {
		this.permanentPhone = permanentPhone;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentStreet() {
		return permanentStreet;
	}

	public void setPermanentStreet(String permanentStreet) {
		this.permanentStreet = permanentStreet;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public int getPermanentZipcode() {
		return permanentZipcode;
	}

	public void setPermanentZipcode(int permanentZipcode) {
		this.permanentZipcode = permanentZipcode;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

	public ArrayList<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(ArrayList<Procedure> procedures) {
		this.procedures = procedures;
	}

	

}
