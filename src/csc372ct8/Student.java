package csc372ct8;

public class Student {
	private String name;
	private String address;
	double gpa; 

	public Student(String name, String address, double gpa) {
		this.name = name;
		this.address = address;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	// Validate the GPA
	public static boolean isValidGPA(double gpa) {
		return gpa >= 0.0 && gpa <= 4.0;
	}


}
