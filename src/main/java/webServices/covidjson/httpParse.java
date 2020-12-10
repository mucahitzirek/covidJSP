package webServices.covidjson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import webServices.jsonsetmodel.jsonsetModel;
import webServices.model.CovidModel;

public class httpParse {

	public static void main(String[] args) {

		// Java 11
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://coronavirus-19-api.herokuapp.com/countries")).build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenApply(httpParse::parse).join();

	}

	@SuppressWarnings("static-access")
	public static String parse(String responseBody) {

		jsonsetModel.getParse(responseBody);

		return null;

	}

}
