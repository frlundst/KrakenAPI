package KrakenAPI;

import java.net.*;
import java.io.*;
import javax.swing.*;

public class Kraken {

	private static HttpURLConnection connection;

	public static String krakenConnect() {
		
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();

		try {

			URL url = new URL("https://api.kraken.com/0/public/Ticker?pair=XBTUSD");

			connection = (HttpURLConnection) url.openConnection(); // Skapa connection

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int status = connection.getResponseCode();

			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}

		return getxbtvalue(responseContent.toString());

	}

	public static String getxbtvalue(String responseBody) {
		char[] responseArray = new char[responseBody.length()];
		String value = "";

		for (int i = 0; i < responseBody.length(); i++) {
			responseArray[i] = responseBody.charAt(i);
		}

		for (int i = 0; i < responseBody.length(); i++) {
			if (responseArray[i] == 'a') {
				for (int j = i + 5; j < i + 13; j++) {
					value += responseArray[j];
				}
				break;
			}
		}
		return value;
	}
}
