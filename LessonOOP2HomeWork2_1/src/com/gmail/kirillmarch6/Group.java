package com.gmail.kirillmarch6;

import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Group implements Voenkom {

	private Student[] group = new Student[10];

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

	public void addStudent(Student student) {// добавление студента
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

	public void interactiveAddingStudent() {// интерактивный ввод студента с клавиатуры и добавление его в массив
		Student s = new Student();
		String sex;
		String surname;
		String name;
		String patronymic;

		try {
			surname = JOptionPane.showInputDialog("Введите фамилию");
			if (surname.equals("")) {
				throw new NullPointerException();
			} else {
				s.setSurname(surname);
			}
			name = JOptionPane.showInputDialog("Введите имя");
			if (name.equals("")) {
				throw new NullPointerException();
			} else {
				s.setName(name);
			}
			patronymic = JOptionPane.showInputDialog("Введите отчество");
			if (patronymic.equals("")) {
				throw new NullPointerException();
			} else {
				s.setPatronymic(patronymic);
			}
			s.setAge(Integer.valueOf(JOptionPane.showInputDialog("Введите возраст")));
			sex = String.valueOf(JOptionPane.showInputDialog("Введите пол (man/woman)"));
			if (sex.equals("man") || sex.equals("woman")) {
				s.setSex(Sex.valueOf(sex));
			} else {
				throw new NoSexExcaption();
			}
			s.setStudentID(Integer.valueOf(JOptionPane.showInputDialog("Введите номер студенческого билета")));
			s.setNumberRecordBook(Integer.valueOf(JOptionPane.showInputDialog("Введите номер зачетной книжки")));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Должно быть число!");
		} catch (NoSexExcaption e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Ничего не было введено или нажата отмена!");
		}

		if (s.getSurname() != null) {
			addStudent(s);
		}
	}

	public void deleteStudent(Student student) {// удаление студента из группы
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].equals(student)) {
					group[i] = null;
					System.out.println("Удален студент " + student.getInformation());
					sortStudentAfterDelStudent();
					break;
				}
				if (i == group.length - 1) {
					System.out.println("Попытка удалить студента неудачна. В группе нет такого студента!");
				}
			}
		}
	}

	public void sortStudentAfterDelStudent() { // переставляем null в массиве после удаления в самый конец
		for (int i = 0; i < group.length - 1; i++) {
			if (group[i] == null && group[i + 1] != null) {
				group[i] = group[i + 1];
				group[i + 1] = null;
			}
		}
	}

	public Student[] arrWithoutNull(Student[] arr) { // вспомогательный метод который вернет массив без null в конце,
														// если они есть
		int number = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			number++;
		}
		Student[] sortList = new Student[number];
		System.arraycopy(arr, 0, sortList, 0, number);
		return sortList;
	}

	public Student searchStudent(String findStudnent) {// поиск студента по фамилии
		Student searchStudent = null;
		for (int i = 0; i < group.length; i++) {
			if (findStudnent.equals(group[i].getSurname())) {
				searchStudent = group[i];
				break;
			}
		}
		return searchStudent;
	}

	public void getInformation() { // вывод информации о студенте
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				System.out.println(group[i].getInformation());
			}
		}
	}

	public Student[] getStudnetsForVoenkom() {// получаем массив 18-летних юношей из исходного массива
		Student[] year18men = new Student[10];
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].getAge() == 18 && group[i].getSex() == Sex.man) {
					for (int j = 0; j < year18men.length; j++) {
						if (year18men[j] == null) {
							year18men[j] = group[i];
							break;
						}
					}
				}
			}
		}
		return arrWithoutNull(year18men);
	}

	public Student[] getInteractiveSortArray() { // интерактивная сортировка с параметром
		Student[] sortArray = new Student[] {};
		sortArray = arrWithoutNull(group); // получаем массив без null в конце
		boolean goodParametr = true;
		String parametr = "";
		try {
			parametr = JOptionPane.showInputDialog(
					"Введите значение параметра сортировки (surname/name/patronymic/age/studentID/numberRecordBook)");
			if (parametr.equals("")) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Ничего не было введено или нажата отмена!");
			return null;
		}
		if (parametr.equals("surname") || parametr.equals("name") || parametr.equals("patronymic")) {
			getInteractiveSortArrayString(sortArray, parametr);
			goodParametr = false;
		}
		if (parametr.equals("age") || parametr.equals("studentID") || parametr.equals("numberRecordBook")) {
			getInteractiveSortArrayInt(sortArray, parametr);
			goodParametr = false;
		}
		if (goodParametr == false) {
			return sortArray;
		} else {
			System.out.println("Неверный параметр!");
			return null;
		}
	}

	public Student[] getInteractiveSortArrayString(Student[] sortArray, String parametr) {
		Arrays.sort(sortArray, new Comparator<Student>() {
			public int compare(Student a, Student b) {
				if (parametr.equals("surname")) {
					return a.getSurname().compareToIgnoreCase(b.getSurname());
				} else if (parametr.equals("name")) {
					return a.getName().compareToIgnoreCase(b.getName());
				} else if (parametr.equals("patronymic")) {
					return a.getPatronymic().compareToIgnoreCase(b.getPatronymic());
				} else {
					return 0;
				}

			}
		});
		return sortArray;
	}

	public Student[] getInteractiveSortArrayInt(Student[] sortArray, String parametr) {
		Arrays.sort(sortArray, new Comparator<Student>() {
			public int compare(Student a, Student b) {
				if (parametr.equals("numberRecordBook") && a.getNumberRecordBook() < b.getNumberRecordBook()) {
					return 1;
				}
				if (parametr.equals("numberRecordBook") && a.getNumberRecordBook() > b.getNumberRecordBook()) {
					return -1;
				}
				if (parametr.equals("studentID") && a.getStudentID() < b.getStudentID()) {
					return 1;
				}
				if (parametr.equals("studentID") && a.getStudentID() > b.getStudentID()) {
					return -1;
				}
				if (parametr.equals("age") && a.getAge() < b.getAge()) {
					return 1;
				}
				if (parametr.equals("age") && a.getAge() > b.getAge()) {
					return -1;
				}
				return 0;
			}
		});
		return sortArray;
	}

}
