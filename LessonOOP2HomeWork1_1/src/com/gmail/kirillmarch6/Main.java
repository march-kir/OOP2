package com.gmail.kirillmarch6;

public class Main {

	public static void main(String[] args) {

		Student studentOne = new Student("Kotelnikov", "Petr", "Stepanovich", 18, Sex.man, 1500126, 45893621);
		Student studentTwo = new Student("Fedorova", "Irina", "Sergeevna", 18, Sex.woman, 1500127, 12589644);
		Student studentThree = new Student("Artemonova", "Olga", "Vadimovna", 17, Sex.woman, 1500128, 25683666);
		Student studentFour = new Student("Bolotnikov", "Victor", "Pavlovich", 17, Sex.man, 1500129, 98124460);
		Student studentFive = new Student("Morozuk", "Illya", "Bogdanovich", 18, Sex.man, 1500130, 03551221);
		Student studentSix = new Student("Prudousova", "Liliya", "Filippovna", 18, Sex.woman, 1500131, 45896312);
		Student studentSeven = new Student("Totvinskii", "German", "Aleksandrovich", 17, Sex.man, 1500132, 63872200);
		Student studentEight = new Student("Lekalo", "Boris", "Ignatovich", 18, Sex.man, 1500133, 50502374);
		Student studentNine = new Student("Boiko", "Mariya", "Andreevna", 18, Sex.woman, 1500134, 10998842);
		Student studentTen = new Student("Sheman", "Victor", "Victorovich", 17, Sex.man, 1500135, 33546602);
		Student studentElleven = new Student("Lisitha", "Anastasiya", "Mihailovna", 18, Sex.woman, 1500136, 87332561);

		Group group = new Group();
		group.addStudent(studentOne);
		group.addStudent(studentTwo);
		group.addStudent(studentThree);
		group.addStudent(studentFour);
		group.addStudent(studentFive);
		group.addStudent(studentSix);
		group.addStudent(studentSeven);
		group.addStudent(studentEight);
		group.addStudent(studentNine);
		group.addStudent(studentTen);
		group.addStudent(studentElleven);
		
		System.out.println();
		
		group.getInformation();
		System.out.println();
		
		group.searchStudent("Morozuk");
		group.searchStudent("Golovin");
		System.out.println();
			
		group.deleteStudent(studentSeven);
		System.out.println();
		group.getInformation();
		
	}

}
