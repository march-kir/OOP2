package com.gmail.kirillmarch6;

public class Student extends Person{

	private int studentID;
	private int numberRecordBook;
	
	public Student(String surname, String name, String patronymic, int age, Sex sex, int studentID,
			int numberRecordBook) {
		super(surname, name, patronymic, age, sex);
		this.studentID = studentID;
		this.numberRecordBook = numberRecordBook;
	}
	public Student() {
		super();
	}
	public Student(String surname, String name, String patronymic, int age, Sex sex) {
		super(surname, name, patronymic, age, sex);
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getNumberRecordBook() {
		return numberRecordBook;
	}
	public void setNumberRecordBook(int numberRecordBook) {
		this.numberRecordBook = numberRecordBook;
	}

	@Override
	public String getInformation() {
		return "Student " + super.getInformation() + ", studentID=" + studentID + ", numberRecordBook=" + numberRecordBook + "]";
	}
	
	
}
