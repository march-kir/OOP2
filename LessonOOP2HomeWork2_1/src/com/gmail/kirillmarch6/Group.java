package com.gmail.kirillmarch6;

import java.util.Arrays;

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

	public void addStudent(Student student) {
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

	public void interactiveAddingStudent() {
		Student s = new Student();
		String sex;

		try {
			s.setSurname(String.valueOf(JOptionPane.showInputDialog("������� �������")));
			s.setName(String.valueOf(JOptionPane.showInputDialog("������� ���")));
			s.setPatronymic(String.valueOf(JOptionPane.showInputDialog("������� ��������")));
			s.setAge(Integer.valueOf(JOptionPane.showInputDialog("������� �������")));
			sex = String.valueOf(JOptionPane.showInputDialog("������� ��� (man, woman)"));
			if (sex.equals("man") || sex.equals("woman")) {
				s.setSex(Sex.valueOf(sex));
			} else {
				throw new NoSexExcaption();
			}
			s.setStudentID(Integer.valueOf(JOptionPane.showInputDialog("������� ����� ������������� ������")));
			s.setNumberRecordBook(Integer.valueOf(JOptionPane.showInputDialog("������� ����� �������� ������")));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "������ ������!");
			return;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "������ ���� �����!");
			return;
		} catch (NoSexExcaption e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
		if (s.getSurname() != null) {
			addStudent(s);
		}
	}

	public void deleteStudent(Student student) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].equals(student)) {
					group[i] = null;
					System.out.println("������ ������� " + student.getInformation());
					break;
				}
				if (i == group.length - 1) {
					System.out.println("������� ������� �������� ��������. � ������ ��� ������ ��������!");
				}
			}
		}
	}

	public void searchStudent(String findStudnent) {
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

	public void getInformation() {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				System.out.println(group[i].getInformation());
			}
		}
	}

	public Student[] getStudnetsForVoenkom() {
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

}
