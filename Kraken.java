package kraken;
import java.util.*;
import java.net.*;
import java.io.*;

public class Kraken {

	private static HttpURLConnection connection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		try {
			
			URL url = new URL("https://api.kraken.com/0/public/Ticker?pair=XBTEUR"); //URL
			
			connection = (HttpURLConnection) url.openConnection(); //Skapa connection
			
			connection.setRequestMethod("GET"); //Metod vid connection
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			System.out.println(status);
			
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream())); //READER
				while((line = reader.readLine()) != null) { //READ THE WHOLE LINE
					responseContent.append(line); //APPEND
				}
				reader.close();
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			
			System.out.println();
			System.out.println(responseContent.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
	}
	
	//public static String parse(String responseBody) {
		//JSONArray albums = new JSONArray(responseBody);
		
	//}
	
	

}
