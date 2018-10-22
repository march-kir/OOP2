package com.gmail.kirillmarch6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindCommonWords {

	public String loadStringFromFile(File file) {
		String text = "";
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) { 
				text += sc.nextLine();
				text += System.lineSeparator();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	public String[] getCommonWordsFromFiles(String[] fileArrayOne, String[] fileArrayTwo) {
		int n = 0;
		for (int i = 0; i < fileArrayOne.length; i++) {
			for (int j = 0; j < fileArrayTwo.length; j++) {
				if (fileArrayOne[i].equals(fileArrayTwo[j])) {
					n++;
				}
			}
		}
		String[] fileArrayThree = new String[n];
		int k = 0;
		for (int i = 0; i < fileArrayOne.length; i++) {
			for (int j = 0; j < fileArrayTwo.length; j++) {
				if (fileArrayOne[i].equals(fileArrayTwo[j])) {
					fileArrayThree[k] = fileArrayOne[i];
					k++;
				}
			}
		}
		return fileArrayThree;

	}

	public void saveStringToFile(String text, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
