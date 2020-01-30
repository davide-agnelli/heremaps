package com.heromaps.client.heromaps.response.weather_conditions;

import java.util.List;

public class LocationTypeResponse {

	private List<WeatherItemsTypeResponse> observation;

	public List<WeatherItemsTypeResponse> getObservation() {
		return observation;
	}

	public void setObservation(List<WeatherItemsTypeResponse> observation) {
		this.observation = observation;
	}

}
