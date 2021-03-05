package assignment6.vashishth.singh;

import java.util.List;

public class Question1 {
	private String empName;
	private String address;
	private String pinCode;
	private List<String> vehicleList;
	public Question1() {
		super();
	}
	public Question1(String empName, String address, String pinCode, List<String> vehicleList) {
		super();
		this.empName = empName;
		this.address = address;
		this.pinCode = pinCode;
		this.vehicleList = vehicleList;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public List<String> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}
	@Override
	public String toString() {
		return "Question1 [empName=" + empName + ", address=" + address + ", pinCode=" + pinCode + ", vehicleList="
				+ vehicleList + "]";
	}
}
