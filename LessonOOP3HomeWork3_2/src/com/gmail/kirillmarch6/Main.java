package com.gmail.kirillmarch6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File fileOne = new File("a.txt");
		File fileTwo = new File("b.txt");
		File fileTree = new File("common.txt");
		FindCommonWords fcw = new FindCommonWords();
		
		String textOne = fcw.loadStringFromFile(fileOne);
		String textTwo = fcw.loadStringFromFile(fileTwo);
		String textThree;

		String[] fileArrayOne;
		String[] fileArrayTwo;

		fileArrayOne = textOne.split(" ");
		fileArrayTwo = textTwo.split(" ");

		textThree = Arrays.toString(fcw.getCommonWordsFromFiles(fileArrayOne, fileArrayTwo)).replace("[", "").replace("]",
				"");
		fcw.saveStringToFile(textThree, fileTree);
	}



}
