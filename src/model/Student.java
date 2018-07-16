package model;

public class Student {
	
	private String name;
	private String subject;
	private String grade;
	
	public Student(String name, String subject, String grade){
		this.name=name;
		this.subject=subject;
		this.grade=grade;
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
