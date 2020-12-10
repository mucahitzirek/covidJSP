package webServices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CovidModel {

	@XmlElement
	private String country;
	@XmlElement
	private int cases;
	@XmlElement
	private int todayCases;
	@XmlElement
	private int deaths;
	@XmlElement
	private int todayDeaths;

	@XmlElement
	private int critical;
	@XmlElement
	private int casesPerOneMillion;
	@XmlElement
	private int deathsPerOneMillion;
	@XmlElement
	private int totalTests;
	@XmlElement
	private int testsPerOneMillion;

	public CovidModel(String country, int cases, int todayCases, int deaths, int todayDeaths, int critical,
			int casesPerOneMillion, int deathsPerOneMillion, int totalTests, int testsPerOneMillion) {
		this.country = country;
		this.cases = cases;
		this.todayCases = todayCases;
		this.deaths = deaths;
		this.todayDeaths = todayDeaths;
		this.critical = critical;
		this.casesPerOneMillion = casesPerOneMillion;
		this.deathsPerOneMillion = deathsPerOneMillion;
		this.totalTests = totalTests;
		this.testsPerOneMillion = testsPerOneMillion;
	}

	public CovidModel() {

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCases() {
		return cases;
	}



	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getTodayDeaths() {
		return todayDeaths;
	}

	public void setTodayDeaths(int todayDeaths) {
		this.todayDeaths = todayDeaths;
	}


	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public int getCasesPerOneMillion() {
		return casesPerOneMillion;
	}

	public void setCasesPerOneMillion(int casesPerOneMillion) {
		this.casesPerOneMillion = casesPerOneMillion;
	}

	public int getDeathsPerOneMillion() {
		return deathsPerOneMillion;
	}

	public void setDeathsPerOneMillion(int deathsPerOneMillion) {
		this.deathsPerOneMillion = deathsPerOneMillion;
	}

	public int getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(int totalTests) {
		this.totalTests = totalTests;
	}

	public int getTestsPerOneMillion() {
		return testsPerOneMillion;
	}

	public void setTestsPerOneMillion(int testsPerOneMillion) {
		this.testsPerOneMillion = testsPerOneMillion;
	}

	public int getTodayCases() {
		return todayCases;
	}

	public void setTodayCases(int todayCases) {
		this.todayCases = todayCases;
	}

	@Override
	public String toString() {
		return "Post [country=" + country + ", cases=" + cases + ", todayCases=" + todayCases + ", deaths=" + deaths
				+ ", todayDeaths=" + todayDeaths + ", critical=" + critical + ", casesPerOneMillion="
				+ casesPerOneMillion + ", deathsPerOneMillion=" + deathsPerOneMillion + ", totalTests=" + totalTests
				+ ", testsPerOneMillion=" + testsPerOneMillion + "]";
	}

}
