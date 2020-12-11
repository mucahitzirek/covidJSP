package webServices.jsonsetmodel;

import org.json.JSONArray;
import org.json.JSONObject;

import webServices.model.CovidModel;

public class jsonsetModel {
	
	public static String getParse(String responseBody) {

		CovidModel covid = new CovidModel();

		JSONArray jsonArray = new JSONArray(responseBody);

		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject jsonObject = jsonArray.getJSONObject(i);

			covid.setCountry(jsonObject.getString("country"));
			covid.setCases(jsonObject.getInt("cases"));
			covid.setTodayCases(jsonObject.getInt("todayCases"));
			covid.setDeaths(jsonObject.getInt("deaths"));
			covid.setTodayDeaths(jsonObject.getInt("todayDeaths"));
			covid.setCritical(jsonObject.getInt("critical"));
			covid.setCasesPerOneMillion(jsonObject.getInt("casesPerOneMillion"));
			covid.setDeathsPerOneMillion(jsonObject.getInt("deathsPerOneMillion"));
			covid.setTotalTests(jsonObject.getInt("totalTests"));
			covid.setTestsPerOneMillion(jsonObject.getInt("testsPerOneMillion"));

			System.out.println(covid);
		}

		return null;

	}
}
