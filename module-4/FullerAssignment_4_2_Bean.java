//Brett Fuller
//CSD-430 Assignment 4.2
//6/15/2025

package fullerAssignment_4_2_Bean;

public class FullerAssignment_4_2_Bean implements java.io.Serializable{
	private String firstName;
	private String lastName;
	private String education;
	private String employer;
	private String contact;
	
	public FullerAssignment_4_2_Bean () {

	}
	
	public void setFirstName (String first) {
		firstName = first;
	}
	
	public String getFirstName () {
		return firstName;
	}
	
	public void setLastName (String last) {
		lastName = last;
	}
	
	public String getLastName () {
		return lastName;
	}
	
	public void setEducation (String ed) {
		education = ed;
	}
	
	public String getEducation () {
		return education;
	}
	
	public void setEmployer (String emp) {
		employer = emp;
	}
	
	public String getEmployer () {
		return employer;
	}
	
	public void setContact (String con) {
		contact = con;
	}
	
	public String getContact () {
		return contact;
	}
		
}
