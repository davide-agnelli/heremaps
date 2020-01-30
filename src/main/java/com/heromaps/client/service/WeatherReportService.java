package com.heromaps.client.service;

import com.heromaps.client.dto.WaypointDTO;
import com.heromaps.client.heromaps.response.weather_conditions.LocationTypeResponse;
import com.heromaps.client.heromaps.response.weather_conditions.WeatherItemsTypeResponse;
import com.heromaps.client.heromaps.response.weather_conditions.WeatherReportResponse;
import com.heromaps.client.heromaps.service.WeatherConditionsService;
import com.heromaps.client.result.WeatheratdestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WeatherReportService {

	@Autowired
	private WeatherConditionsService weatherConditionsService;

	public WeatheratdestResponse getWeatherReport(List<WaypointDTO> waypoints) throws IOException {

		final WaypointDTO endWaypoint = getEndWaypoint(waypoints);
		final WeatherReportResponse weatherReportResponse = weatherConditionsService.weatherReport(endWaypoint.lat, endWaypoint.lng);

		final List<LocationTypeResponse> locationTypeResponses = weatherReportResponse.getObservations().getLocation();

		//Validate if weather report response is valid
		if (locationTypeResponses.size() > 1 || locationTypeResponses.size() > 1) {
			throw new IllegalStateException();
		}

		final List<WeatherItemsTypeResponse> observation = locationTypeResponses.get(0).getObservation();
		if (observation == null || observation.size() > 1) {
			throw new IllegalStateException();
		}

		final WeatherItemsTypeResponse weatherItemsTypeResponse = observation.get(0);

		final WeatheratdestResponse weatheratdestResponse = new WeatheratdestResponse();
		weatheratdestResponse.setDaylight(weatherItemsTypeResponse.getDaylight());
		weatheratdestResponse.setDescription(weatherItemsTypeResponse.getDescription());
		weatheratdestResponse.setTemperature(weatherItemsTypeResponse.getTemperature());
		return weatheratdestResponse;
	}

	/**
	 * Calculate last waypoint
	 *
	 * @param waypoints
	 * @return
	 */
	private WaypointDTO getEndWaypoint(List<WaypointDTO> waypoints) {
		return waypoints.get(waypoints.size() - 1);
	}

}
