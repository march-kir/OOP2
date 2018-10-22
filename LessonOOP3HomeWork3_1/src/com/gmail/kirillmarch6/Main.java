package com.gmail.kirillmarch6;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		String[] arr = new String[] { "doc", "docx" };
		MyFileFilter mFF = new MyFileFilter(arr);
		File in = new File("FromCopy");
		File[] fileList = in.listFiles(mFF);
		for (File file : fileList) {
			System.out.println(file.getName());
			try {
				File out = new File("ToCopy\\"+file.getName());
				FileWork.copyFile(file, out);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
