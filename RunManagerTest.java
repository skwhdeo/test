package com.lgcns.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class RunManagerTest {

	@Test
	void test() {
		MyService service = new MyService();
		File commands = new File("SAMPLE/SAMPLE.TXT");
		File ans = new File("SAMPLE/CMP_CONSOLE.TXT");
		try (BufferedReader br = new BufferedReader(new FileReader(commands))) {
			try (BufferedReader br2 = new BufferedReader(new FileReader(ans))) {
			    String line;
			    String line_console;
			    while ((line = br.readLine()) != null) {
			    	
			    		System.out.println("sam:"+line);		    		
			    		if ((line_console = br2.readLine()) != null) {
			    			System.out.println("ans:"+line_console);
			    			assertEquals(line, line_console);
		    				String line_ans = service.doCommand(line);
		    				if(line_ans != null) {
		    					if ((line_console = br2.readLine()) != null) {
		    						System.out.println(line_console+"="+line_ans);
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

}
