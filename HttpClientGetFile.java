package com.lgcns.test;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

public class HttpClientGetFile {

	public static void main(String[] args) throws Exception {

	}

	public void GetFile1() {

		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/requestFile").method(HttpMethod.GET)
				.send();
		byte[] myByteArray = contentRes.getContent();
		try (FileOutputStream fos = new FileOutputStream("C:\\temp\\test.jpg")) {
			fos.write(myByteArray);
		}
		httpClient.stop();
	}

	public void GetFile2() {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/requestFile2").method(HttpMethod.GET)
				.send();
		byte[] myByteArray = contentRes.getContent();
		ByteArrayInputStream byteIn = new ByteArrayInputStream(myByteArray);
		ObjectInputStream in = new ObjectInputStream(byteIn);
		Map<String, byte[]> data2 = (Map<String, byte[]>) in.readObject();
		try (FileOutputStream fos = new FileOutputStream("C:\\temp\\test.jpg")) {
			fos.write(data2.get("file"));
		}
		httpClient.stop();
	}
	
	public String GetDate() {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes =
				httpClient.newRequest("http://127.0.0.1:8080/requestDate").method(HttpMethod.GET).send();
		System.out.println(contentRes.getContentAsString());
		String ret = contentRes.getContentAsString();
		httpClient.stop();
		return ret;
	}
}
