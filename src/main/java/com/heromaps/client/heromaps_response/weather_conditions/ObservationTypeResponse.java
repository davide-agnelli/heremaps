package com.heromaps.client.heromaps_response.weather_conditions;

import java.util.List;

public class ObservationTypeResponse {

	private List<LocationTypeResponse> location;

	public List<LocationTypeResponse> getLocation() {
		return location;
	}

	public void setLocation(List<LocationTypeResponse> location) {
		this.location = location;
	}

}
