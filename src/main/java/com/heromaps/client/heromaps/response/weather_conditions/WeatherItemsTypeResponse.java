package com.heromaps.client.heromaps.response.weather_conditions;

public class WeatherItemsTypeResponse {

	private String daylight;
	private String description;
	private Float temperature;

	public String getDaylight() {
		return daylight;
	}

	public void setDaylight(String daylight) {
		this.daylight = daylight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

}
