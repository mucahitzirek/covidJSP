package webServices.covidjson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import webServices.model.CovidModel;

public class CovidListForjava11 {

	private static final String post_api = "https://coronavirus-19-api.herokuapp.com/countries";

	public static void main(String[] args) throws IOException, InterruptedException {

		// Java 11 method - 2
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json")
				.uri(URI.create(post_api)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		ObjectMapper mapper = new ObjectMapper();
		// Liste olusturuluyor
		List<CovidModel> posts = mapper.readValue(response.body(), new TypeReference<List<CovidModel>>() {
		});

		posts.forEach(System.out::println);

	}

}
