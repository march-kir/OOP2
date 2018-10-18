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

	public void addStudent(Student student) {// ���������� ��������
		for (int i = 0; i < group.length; i++) {
			try {
				if (group[i] == null) {
					group[i] = student;
					System.out.println("�������� ������� " + student.getInformation());
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

	public void interactiveAddingStudent() {// ������������� ���� �������� � ���������� � ���������� ��� � ������
		Student s = new Student();
		String sex;
		String surname;
		String name;
		String patronymic;

		try {
			surname = JOptionPane.showInputDialog("������� �������");
			if (surname.equals("")) {
				throw new NullPointerException();
			} else {
				s.setSurname(surname);
			}
			name = JOptionPane.showInputDialog("������� ���");
			if (name.equals("")) {
				throw new NullPointerException();
			} else {
				s.setName(name);
			}
			patronymic = JOptionPane.showInputDialog("������� ��������");
			if (patronymic.equals("")) {
				throw new NullPointerException();
			} else {
				s.setPatronymic(patronymic);
			}
			s.setAge(Integer.valueOf(JOptionPane.showInputDialog("������� �������")));
			sex = String.valueOf(JOptionPane.showInputDialog("������� ��� (man/woman)"));
			if (sex.equals("man") || sex.equals("woman")) {
				s.setSex(Sex.valueOf(sex));
			} else {
				throw new NoSexExcaption();
			}
			s.setStudentID(Integer.valueOf(JOptionPane.showInputDialog("������� ����� ������������� ������")));
			s.setNumberRecordBook(Integer.valueOf(JOptionPane.showInputDialog("������� ����� �������� ������")));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "������ ���� �����!");
		} catch (NoSexExcaption e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "������ �� ���� ������� ��� ������ ������!");
		}

		if (s.getSurname() != null) {
			addStudent(s);
		}
	}

	public void deleteStudent(Student student) {// �������� �������� �� ������
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].equals(student)) {
					group[i] = null;
					System.out.println("������ ������� " + student.getInformation());
					sortStudentAfterDelStudent();
					break;
				}
				if (i == group.length - 1) {
					System.out.println("������� ������� �������� ��������. � ������ ��� ������ ��������!");
				}
			}
		}
	}

	public void sortStudentAfterDelStudent() { // ������������ null � ������� ����� �������� � ����� �����
		for (int i = 0; i < group.length - 1; i++) {
			if (group[i] == null && group[i + 1] != null) {
				group[i] = group[i + 1];
				group[i + 1] = null;
			}
		}
	}

	public Student[] arrWithoutNull(Student[] arr) { // ��������������� ����� ������� ������ ������ ��� null � �����,
														// ���� ��� ����
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

	public void searchStudent(String findStudnent) {// ����� �������� �� �������
		for (int i = 0; i < group.length; i++) {
			if (findStudnent.equals(group[i].getSurname())) {
				System.out.println("������ ������� " + group[i].getInformation());
				break;
			}
			if (i == group.length - 1) {
				System.out.println("�� ������ ������� ������ �� �������");
			}
		}
	}

	public void getInformation() { // ����� ���������� � ��������
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				System.out.println(group[i].getInformation());
			}
		}
	}

	public Student[] getStudnetsForVoenkom() {// �������� ������ 18-������ ������ �� ��������� �������
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

		return year18men;
	}

	public Student[] getInteractiveSortArray() { //������������� ���������� � ����������
		Student[] sortArray = new Student[] {};
		sortArray = arrWithoutNull(group); // �������� ������ ��� null � �����
		boolean goodParametr = true;
		String parametr = "";
		try {
			parametr = JOptionPane.showInputDialog(
					"������� �������� ��������� ���������� (surname/name/patronymic/age/studentID/numberRecordBook)");
			if (parametr.equals("")) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "������ �� ���� ������� ��� ������ ������!");
			return null;
		}
		if (parametr.equals("surname")) {
			Arrays.sort(sortArray, new Comparator<Student>() {
				public int compare(Student a, Student b) {
					return a.getSurname().compareToIgnoreCase(b.getSurname());
				}
			});
			goodParametr = false;
		}
		if (parametr.equals("name")) {
			Arrays.sort(sortArray, new Comparator<Student>() {
				public int compare(Student a, Student b) {
					return a.getName().compareToIgnoreCase(b.getName());
				}
			});
			goodParametr = false;
		}
		if (parametr.equals("patronymic")) {
			Arrays.sort(sortArray, new Comparator<Student>() {
				public int compare(Student a, Student b) {
					return a.getPatronymic().compareToIgnoreCase(b.getPatronymic());
				}
			});
			goodParametr = false;
		}
		if (parametr.equals("age")) {
			Arrays.sort(sortArray, new Comparator<Student>() {
				public int compare(Student a, Student b) {
					if (a.getAge() < b.getAge()) {
						return 1;
					}
					if (a.getAge() > b.getAge()) {
						return -1;
					}
					return 0;
				}
			});
			goodParametr = false;
		}
		if (parametr.equals("studentID")) {
			Arrays.sort(sortArray, new Comparator<Student>() {
				public int compare(Student a, Student b) {
					if (a.getStudentID() < b.getStudentID()) {
						return 1;
					}
					if (a.getStudentID() > b.getStudentID()) {
						return -1;
					}
					return 0;
				}
			});
			goodParametr = false;
		}
		if (parametr.equals("numberRecordBook")) {
			Arrays.sort(sortArray, new Comparator<Student>() {
				public int compare(Student a, Student b) {
					if (a.getNumberRecordBook() < b.getNumberRecordBook()) {
						return 1;
					}
					if (a.getNumberRecordBook() > b.getNumberRecordBook()) {
						return -1;
					}
					return 0;
				}
			});
			goodParametr = false;
		}
		if (goodParametr = false) {
			return sortArray;
		} else {
			System.out.println("�������� ��������!");
			return null;
		}
	}

}
