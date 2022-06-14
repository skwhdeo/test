package com.lgcns.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class RunManagerTest {

	@Test
	void test() {
		MyService service = new MyService();
		try (BufferedReader brIn = new BufferedReader(new FileReader("SAMPLE/SAMPLE.TXT"))) {
			try (BufferedReader brOut = new BufferedReader(new FileReader("SAMPLE/CMP_CONSOLE.TXT"))) {
				String line;
				String line_console;
				while ((line = brIn.readLine()) != null) {

					System.out.println("sam:" + line);
					if ((line_console = brOut.readLine()) != null) {
						System.out.println("ans:" + line_console);
						assertEquals(line, line_console);
						String line_ans = service.doCommand(line);
						if (line_ans != null) {
							if ((line_console = brOut.readLine()) != null) {
								System.out.println(line_console + "=" + line_ans);
								assertEquals(line_console, line_ans);
							}
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	void test2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		Date date = new Date();

		System.out.println("now  (" + format.format(date) + ")");

	}

	@Test
	void test3() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		Date date = new Date(System.currentTimeMillis());

		System.out.println("now  (" + format.format(date) + ")");
	}

	@Test
	void test4() {
		String str = "2020-01-31 14:20:59";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;

		try {
			date = format.parse(str);
		} catch (ParseException e) {
		}

		long timeMillis = date.getTime();
		System.out.println("time millis : " + timeMillis);

	}
}
