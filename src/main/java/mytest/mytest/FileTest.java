package mytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class FileTest {
	// 파일삭제
	// 파일이동,이름바꾸기
	// 파일시간 가져오기
	@Test
	void test() {
		String[] s = new String[] {};
		System.out.println(s.length);
		File[] files = FileTest.listDir(new File("."));
		for (File file : files) {
			System.out.println(file.getPath());
		}
		File from = new File("./TestFile.txt");
		try {
			PrintWriter pw = new PrintWriter(from);
			pw.println("TestFile1234");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File to = new File("./bin/TestFile2.txt");
		if (from.exists())
			from.renameTo(to);
		try {
			BufferedReader br = new BufferedReader(new FileReader(to));
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}

		copyFile(from, new File("./bin/TestFile3.txt"));
		for (File file : FileTest.listDir(new File("./bin"))) {
			System.out.println(file.getPath());
		}
		System.out.println("bef:" + from.toPath() + ":" + from.exists());
		try {
			Files.deleteIfExists(from.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aft:" + from.toPath() + ":" + from.exists());
	}

	public static File[] listDir(File dir) {
		ArrayList<File> list = new ArrayList<>();
		File[] fileList = dir.listFiles();
		for (File file : fileList) {
			if (file.isDirectory()) {
				list.add(file);
				list.addAll(Arrays.asList(listDir(file)));
			} else {
				list.add(file);
			}
		}
		return list.toArray(new File[] {});
	}

	public static void copyFile(File fromFile, File toFile) {
		try {
			FileInputStream in = new FileInputStream(fromFile);
			FileOutputStream out = new FileOutputStream(toFile);
			byte[] b = new byte[4096];
			int cnt = 0;
			while ((cnt = in.read(b)) != -1) {
				out.write(b, 0, cnt);
			}
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void fileTimeTest() {
		File f = new File(".");
		try {
			FileTime ft = Files.getLastModifiedTime(f.toPath());
			System.out.println(ft.toInstant().toString().replace("T", " ").replace("Z", ""));
			System.out.println(Instant.now().toString().replace("T", " ").replace("Z", ""));
			System.out.println(ft.toInstant().plusSeconds(24 * 60 * 60).isBefore(Instant.now()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
