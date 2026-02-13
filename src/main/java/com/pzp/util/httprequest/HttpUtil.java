package com.pzp.util.httprequest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

	public static String get(String body, String url, String method) {
		StringBuffer sf = new StringBuffer();
		String line = "";
		try {
			URL urlString = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlString.openConnection();
			connection.addRequestProperty("Content-Type", "Application/json");
			connection.addRequestProperty("Authration", "");
			connection.addRequestProperty("Cookie", "");
			connection.setRequestMethod("GET");
			connection.connect();
//			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//			out.write(body.getBytes());
//			out.flush();
//			out.close();
			InputStream inputStream = null;
			if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
				inputStream = connection.getInputStream();
			} else {
				inputStream = connection.getErrorStream();
			}
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			while ((line = bufferedReader.readLine()) != null) {
				sf.append(line);			
			}
			inputStream.close();
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = sf.toString();
		System.out.println("请求连接为：" + url + ",入参body为：" + body + ",响应结果为：" + result + "");
		return result;
	}
	
	public static void main(String[] args) {
		get("", "http://www.example.com", "test");
	}
	
}
