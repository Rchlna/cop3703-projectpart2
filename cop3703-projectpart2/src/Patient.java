
public class Patient {

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
	
	public Patient(String id, char sex, String currentPhone, String currentAddress, String permanentPhone, 
			String permanentStreet, String permanentCity, String permanentState, int permanentZipcode){
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

}
