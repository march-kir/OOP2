package com.gmail.kirillmarch6;


public class Group {

	Student[] group = new Student[10];

	public Group(Student[] group) {
		super();
		this.group = group;
	}

	public Group() {
		super();
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}


	public void addStudent(Student student) {
		for (int i = 0; i < group.length; i++) {
			try {
				if (group[i] == null) {
					group[i] = student;
					System.out.println("Добавлен студент " + student.getInformation());
					break;
				}
				if (i == group.length - 1) {
					throw new QuantityOverflowException();
				}
			} catch (QuantityOverflowException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void deleteStudent(Student student) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] == student) {
				group[i] = null;
				System.out.println("Удален студент " + student.getInformation());
				break;
			}
			if (i == group.length - 1) {
				System.out.println("Попытка удалить студента неудачна. В группе нет такого студента!");
			}
		}
	}

	public void searchStudent(String findStudnent) {
		for (int i = 0; i < group.length; i++) {
			if (findStudnent.equals(group[i].getSurname())) {
				System.out.println("Найден студент " + group[i].getInformation());
				break;
			}
			if (i == group.length - 1) {
				System.out.println("По вашему запросу ничего не найдено");
			}
		}
	}

	public void getInformation() {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				System.out.println(group[i].getInformation());
			}
		}
	}

}
