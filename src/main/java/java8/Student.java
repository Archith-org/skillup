package java8;

public class Student {
	
	private int id;
	private String studentName;
	private double rank;
	private String state;
	private String country;
	
	public Student(int id, String studentName, double rank, String state, String country) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.rank = rank;
		this.state = state;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", rank=" + rank + ", state=" + state
				+ ", country=" + country + "]";
	}
	
	
	
	

}
