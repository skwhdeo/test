package mytest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessTest2 {

	public static void main(String[] args) throws Exception {

		Runtime r = Runtime.getRuntime();

//		Process p1 = r.exec("notepad");
//
//		p1.waitFor(3, TimeUnit.SECONDS);
//
//		p1.destroy();


		ProcessBuilder processBuilder = new ProcessBuilder("test.bat");

//		processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
//		processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
//		processBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);

		Process p = processBuilder.start();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		System.out.println(br.readLine());
		bw.write("hello");
		bw.newLine();
		bw.flush();
		System.out.println(br.readLine());
		bw.write("end");
		bw.newLine();
		bw.flush();
		System.out.println(br.readLine());
//		PrintWriter pw = new PrintWriter(p.getOutputStream());
//		pw.println("hello");
//		pw.flush();
//		pw.println("end");
//		pw.flush();
		p.waitFor();

		List<String> commands = new ArrayList<String>(
				Arrays.asList("test.bat", "argumentsTest1", "argumentsTest2", "argumentsTest3"));
		ProcessBuilder processBuilder2 = new ProcessBuilder(commands);
		processBuilder2.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		processBuilder2.redirectError(ProcessBuilder.Redirect.INHERIT);
		processBuilder2.redirectInput(ProcessBuilder.Redirect.INHERIT);
		Process pp = processBuilder2.start();

		pp.waitFor();

//		ProcessBuilder p11 = new ProcessBuilder("test.bat");
//		p11.redirectInput();
//		InputStream is1 = p11.getInputStream();
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(is1));
//		PrintWriter pw11 = new PrintWriter(p11.getOutputStream());
//		pw11.println("hello world");
//		pw11.println("hello world");
//		
//		for (String str; (str = br.readLine()) != null;) {
//
//			System.out.println(str);
//
//		}
//
//
//		p11.waitFor(3, TimeUnit.SECONDS);
//
//		p11.destroy();
//
//		ProcessBuilder pb1 = new ProcessBuilder("notepad", "a,txt");
//
//		Process p2 = pb1.start();
//
//		p2.waitFor(3, TimeUnit.SECONDS);
//
//		p2.destroy();
//
// 
//
//		Process p3 = r.exec("ping 127.0.0.1");
//
//		InputStream is1 = p3.getInputStream();
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(is1));
//
//		for (String str; (str = br.readLine()) != null;) {
//
//			System.out.println(str);
//
//		}
//
//		System.out.println("Process ended...(종료코드) ::: " + p3.exitValue());
//
//		
//
//		Thread.sleep(3000);
//
//		
//
//		ProcessBuilder pb2 = new ProcessBuilder("ping", "127.0.0.1");
//
//		Process p4 = pb2.start();
//
//		InputStream is2 = p4.getInputStream();
//
//		BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
//
//		for (String str; (str = br2.readLine()) != null;) {
//
//			System.out.println(str);
//
//		}
//
//		System.out.println("Process ended...(종료코드) ::: " + p4.exitValue());

	}

}
