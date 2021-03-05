package assignment4.vashishth.singh;

import java.util.Scanner;

public class Contact {
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String gender;
	private String anniversary;
	private String address;
	private String area;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private String telephoneNumber;
	private String mobileNumber;
	private String email;
	private String Website;
	
	public Contact() {
		super();
	}

	public Contact(String firstName, String middleName, String lastName, String dob, String gender, String anniversary,
			String address, String area, String city, String pincode, String state, String country,
			String telephoneNumber, String mobileNumber, String email, String website) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.anniversary = anniversary;
		this.address = address;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.telephoneNumber = telephoneNumber;
		this.mobileNumber = mobileNumber;
		this.email = email;
		Website = website;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dob="
				+ dob + ", gender=" + gender + ", anniversary=" + anniversary + ", address=" + address + ", area="
				+ area + ", city=" + city + ", pincode=" + pincode + ", state=" + state + ", country=" + country
				+ ", telephoneNumber=" + telephoneNumber + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", Website=" + Website + "]";
	}
	public void validate() throws CustomException,StringIndexOutOfBoundsException,NullPointerException{
		if(this.getFirstName().length()==0) {
			throw new CustomException("First Name Can Not Be Empty");
		}
		if(this.getLastName().length()==0) {
			throw new CustomException("Last Name Can Not Be Empty");
		}
		if(this.getDob().length()==0) {
			throw new CustomException("DOB Can Not Be Empty");
		}
		if(this.getEmail().length()==0) {
			throw new CustomException("Email Can Not Be Empty");
		}
		
		String isEmailValid=this.getEmail();
		isEmailValid=isEmailValid.substring(isEmailValid.length() - 10);
		
		if(!isEmailValid.equals("@gmail.com") && !isEmailValid.equals("@yahoo.com")) {
			throw new CustomException("Invalid Email :=> i.e. something@gmail.com or something@yahoo.com");
		}
		if(this.getTelephoneNumber().length()==0 && this.getMobileNumber().length()==0) {
			throw new CustomException("Provide Telephone Number Or Mobile Number");
		}
	}
	public void setAndValidateObject() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter First Name"); 
		this.setFirstName(sc.nextLine());
		
		System.out.println("Enter Middle Name"); 
		this.setMiddleName(sc.nextLine());
		
		System.out.println("Enter Last Name"); 
		this.setLastName(sc.nextLine());
		
		System.out.println("Enter Date Of Birth"); 
		this.setDob(sc.nextLine());
		
		System.out.println("Enter Gender "); 
		this.setGender(sc.nextLine());
		
		System.out.println("Enter Anniversary"); 
		this.setAnniversary(sc.nextLine());
		
		System.out.println("Enter Address"); 
		this.setAddress(sc.nextLine());
		
		System.out.println("Enter Area"); 
		this.setArea(sc.nextLine());
		
		System.out.println("Enter City"); 
		this.setCity(sc.nextLine());
		
		System.out.println("Enter Pincode"); 
		this.setPincode(sc.nextLine());
		
		System.out.println("Enter State"); 
		this.setState(sc.nextLine());
		
		System.out.println("Enter Country"); 
		this.setCountry(sc.nextLine());
		
		System.out.println("Enter Telephone Number"); 
		this.setTelephoneNumber(sc.nextLine());
		
		System.out.println("Enter Mobile Number"); 
		this.setMobileNumber(sc.nextLine());
		
		System.out.println("Enter Email"); 
		this.setEmail(sc.nextLine());
		
		System.out.println("Enter Website"); 
		this.setWebsite(sc.nextLine());
		//sc.close();
		
	    try{  
	    	this.validate();
	    }catch(CustomException ce){
	    	System.out.println("Exception occured: "+ce);
	    }catch(StringIndexOutOfBoundsException ex) {
	    	System.out.println("Exception occured: "+ex+" ::Email Length Must Be Greater Than 10 Char");
	    	System.out.println("i.e. => something@gmaol.com or something@yahoo.com");
	    }catch(NullPointerException ne) {
	    	System.out.println("Exception occured: "+ne);
	    }
	}
	public static void main(String args[]){  
		Contact contact=new Contact();
		contact.setAndValidateObject();
		System.out.println(contact);  
	}  
	
}
