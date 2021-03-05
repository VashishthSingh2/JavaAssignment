package assignment6.vashishth.singh;

import java.time.LocalDate;

public class EmployeeBeanClass implements Comparable<EmployeeBeanClass>{
	private String name;
	private String designation;
	private int id;
	private LocalDate joingDate;
	
	
	public EmployeeBeanClass() {
		super();
	}
	public EmployeeBeanClass(String name, String designation, int id, LocalDate joingDate) {
		super();
		this.name = name;
		this.designation = designation;
		this.id = id;
		this.joingDate = joingDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return joingDate;
	}
	public void setDate(LocalDate joingDate) {
		this.joingDate = joingDate;
	}
	@Override
	public String toString() {
		return "EmployeeBeanClass [name=" + name + ", designation=" + designation + ", id=" + id + ", joingDate=" + joingDate
				+ "]";
	}
	@Override
	public int compareTo(EmployeeBeanClass emp) {
		 if(id>emp.id)
		      return 1;  
		  else if(id<emp.id)
		      return -1;  
		  else
		    return 0;  
	}
}
