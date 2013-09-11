package fr.treeptik.controller;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.treeptik.wsimport.WeatherReturn;
import fr.treeptik.wsimport.WeatherSoap;

@ManagedBean(name = "globalMB")
public class GlobalManagedBean {

	@Inject
	private WeatherSoap weatherSoap;

	// public String getMeteo() {
	// StringBuilder sb = new StringBuilder();
	// WeatherReturn nyWeather = weatherSoap.getCityWeatherByZIP("10004");
	//
	// String city = nyWeather.getCity();
	// String temperature = nyWeather.getTemperature();
	// String humidity = nyWeather.getRelativeHumidity();
	//
	// sb.append((city != null) ? city + " | " : "");
	// sb.append((temperature != null) ? temperature + " °F | " : "");
	// sb.append((humidity != null) ? humidity + " % Humidite" : "");
	//
	// if (city != null) {
	//
	// }
	//
	// return sb.toString();
	// }

	
	
		public String getMeteo() {
			
		StringBuilder sb = new StringBuilder();
		WeatherReturn nyWeather = weatherSoap.getCityWeatherByZIP("10004");

		String city = nyWeather.getCity();
		String temperature = nyWeather.getTemperature();
		String humidity = nyWeather.getRelativeHumidity();

		// sb.append((city != null) ? city + " | " : "");
		// sb.append((temperature != null) ? temperature + " °F | " : "");
		// sb.append((humidity != null) ? humidity + " % Humidite" : "");

		if (city != null) {
			sb.append(city);

			if (temperature != null) {
				sb.append(" | ");
				sb.append(temperature);
				sb.append(" °F");
			}

			if (humidity != null) {
				sb.append(" | ");
				sb.append(humidity);
				sb.append(" % Humidite");
			}
		}

		return sb.toString();
	}
}
