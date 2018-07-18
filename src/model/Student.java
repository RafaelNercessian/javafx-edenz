package model;

public class Student {
	
	private String name;
	private String subject;
	private String grade;
	
	
	public Student(String name, String subject, String grade) {
		this.name = name;
		this.subject = subject;
		this.grade = grade;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public String getGrade() {
		return grade;
	}
	
	

}
