
public class Department {

	public String name;
	public String code;
	public int officeNumber;
	public String officePhone;
	public String deptHead;
	
	public Department(String name, String code, int officeNumber, String officePhone, String deptHead) {
		this.name = name;
		this.code = code;
		this.officeNumber = officeNumber;
		this.officePhone = officePhone;
		this.deptHead = deptHead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

}
