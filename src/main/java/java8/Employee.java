package java8;

public class Employee {
	
	
	
	public Employee(int id, String employeeName, String department, double salary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.department = department;
		this.salary = salary;
	}
	
	
	private int id;
	private String employeeName;
	private String department;
	private double salary;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", department=" + department + ", salary="
				+ salary + "]";
	}
	
	

}
