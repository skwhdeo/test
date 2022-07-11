package mytest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

 

public class ProcessTest2 {

	public static void main(String[] args) throws Exception {

		Runtime r = Runtime.getRuntime();

//		Process p1 = r.exec("notepad");
//
//		p1.waitFor(3, TimeUnit.SECONDS);
//
//		p1.destroy();


		Process p11 = r.exec("cmd /c echo");

		InputStream is1 = p11.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is1));
		PrintWriter pw11 = new PrintWriter(p11.getOutputStream());
		for (String str; (str = br.readLine()) != null;) {

			System.out.println(str);
			pw11.write(str);
		}


		p11.waitFor(3, TimeUnit.SECONDS);

		p11.destroy();
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
