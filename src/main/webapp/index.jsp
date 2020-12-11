<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page import="java.io.*,java.util.Locale" %>
<%@ page import="java.text.DateFormat,java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="webServices.model.*"%>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<html>

<body>
	<%
   		  Locale local = request.getLocale( );
   		  String timeDate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT,local).format(new Date( ));
	%>
	
		<h1 align="center">
		<%
		out.print(timeDate);
		%>
		</h1>
	
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Country</th>
				<th scope="col">Cases</th>
				<th scope="col">TodayCases</th>
				<th scope="col">Deaths</th>
				<th scope="col">TodayDeaths</th>
				<th scope="col">Critical</th>
				<th scope="col">CasesPerOneMillion</th>
				<th scope="col">DeathsPerOneMillion</th>
				<th scope="col">TotalTests</th>
				<th scope="col">TestsPerOneMillion</th>
			</tr>
		</thead>
		<%
			String urlCovid = "https://coronavirus-19-api.herokuapp.com/countries";
			CovidModel covid = new CovidModel();
			try {
				URL url = new URL(urlCovid);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/xml");

				if (connection.getResponseCode() != 200) {
					throw new RuntimeException("Basarisiz : " + connection.getResponseCode());
				}

				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String result = bufferedReader.readLine();
				JSONArray jsonArray = new JSONArray(result);

				for (int i = 0; i < jsonArray.length(); i++) {

					JSONObject jsonObject = jsonArray.getJSONObject(i);
					covid.setCountry(jsonObject.getString("country"));
					covid.setCases(jsonObject.getInt("cases"));
					covid.setTodayCases(jsonObject.getInt("todayCases"));
					covid.setDeaths(jsonObject.getInt("deaths"));
					covid.setTodayDeaths(jsonObject.getInt("todayDeaths")); // recovered
					covid.setCritical(jsonObject.getInt("critical"));
					covid.setCasesPerOneMillion(jsonObject.getInt("casesPerOneMillion"));
					covid.setDeathsPerOneMillion(jsonObject.getInt("deathsPerOneMillion"));
					covid.setTotalTests(jsonObject.getInt("totalTests"));
					covid.setTestsPerOneMillion(jsonObject.getInt("testsPerOneMillion"));
		%>
		<tbody>
			<tr>
				<td><%=covid.getCountry()%></td>
				<td><%=covid.getCases()%></td>
				<td><%=covid.getTodayCases()%></td>
				<td><%=covid.getDeaths()%></td>
				<td><%=covid.getTodayDeaths()%></td>
				<td><%=covid.getCritical()%></td>
				<td><%=covid.getCasesPerOneMillion()%></td>
				<td><%=covid.getDeathsPerOneMillion()%></td>
				<td><%=covid.getTotalTests()%></td>
				<td><%=covid.getTestsPerOneMillion()%></td>
			</tr>
		</tbody>
		<%
			System.out.println(covid.getCountry());
				}
				connection.disconnect();

			} catch (Exception e) {
				System.out.println("Hata : " + e.getMessage());

			}
		%>
	</table>

</body>
</html>
