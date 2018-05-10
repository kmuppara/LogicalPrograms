package com.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
//need gson jar for this import
import com.google.gson.Gson;

//Example for access RestFul GET API from simple java program.
public class TestMay11 {

	public static void main(String[] args) {
		String output = callURL("https://jsonmock.hackerrank.com/API/movies/search/?Title=maze");
		System.out.println("O/p" + output);
		
		Gson gson = new Gson(); // Or use new GsonBuilder().create();
		/* MyType target = new MyType();
		 String json = gson.toJson(target); // serializes target to Json
*/		 MyJson target2 = gson.fromJson(output, MyJson.class); // deserializes json into target2
		System.out.println(target2.toString());
	}
 
	public static String callURL(String myURL) {
		System.out.println("Requested URL: " + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:" + myURL, e);
		}
 
		return sb.toString();
}
	}