package webServices.covidjson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import webServices.jsonsetmodel.jsonsetModel;

public class CovidList {

	public static final String urlCovid = "https://coronavirus-19-api.herokuapp.com/countries";

	public static void main(String[] args) {
		covidCountry();
	}

	public static void covidCountry() {

		try {
			// Java 8 method - 1

			URL url = new URL("https://coronavirus-19-api.herokuapp.com/countries");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Basarisiz : " + connection.getResponseCode());
			}

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = bufferedReader.readLine();

			// json
			jsonsetModel.getParse(result);

			connection.disconnect();
		} catch (

		Exception e) {

			System.out.println("Hata : " + e.getMessage());

		}
	}

}
