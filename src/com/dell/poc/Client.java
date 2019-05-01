package com.dell.poc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.google.com");

//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("<IP>", <PORT>));
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
//			conn.setRequestProperty("Authorization", "Basic XXXXXXXXXXXXXXXXXX=");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code: " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			System.out.println("Output from Server ... \n");

			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
