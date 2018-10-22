package com.gmail.kirillmarch6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileWork {

	public static void copyFile(File in, File out) throws IOException {

		if (in == null || out == null) {
			throw new IllegalArgumentException();
		}
		try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {

			int n = 0;
			byte[] buffer = new byte[1024 * 1024];

			for (; (n = is.read(buffer)) > 0;) {
				os.write(buffer, 0, n);
			}

		} catch (IOException e) {
			throw e;
		}

	}
}
