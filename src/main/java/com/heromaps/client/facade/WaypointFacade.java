package com.heromaps.client.facade;

import com.heromaps.client.dto.WaypointDTO;
import com.heromaps.client.heromaps_response.weather_conditions.LocationTypeResponse;
import com.heromaps.client.heromaps_response.weather_conditions.WeatherItemsTypeResponse;
import com.heromaps.client.heromaps_response.weather_conditions.WeatherReportResponse;
import com.heromaps.client.result.EvaluateTravelPoint;
import com.heromaps.client.result.WeatheratdestResponse;
import com.heromaps.client.service.WeatherConditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WaypointFacade {

	@Autowired
	private WeatherConditionsService weatherConditionsService;

	public EvaluateTravelPoint calculate(List<WaypointDTO> waypoints) throws IOException {

		final WaypointDTO waypointDTO = waypoints.get(waypoints.size() - 1);

		final WeatherReportResponse weatherReportResponse = weatherConditionsService.weatherReport(waypointDTO.lat, waypointDTO.lng);

		//TODO Re organize
		WeatheratdestResponse weatheratdestResponse = null;
		final List<LocationTypeResponse> location = weatherReportResponse.getObservations().getLocation();
		if (location != null && location.size() > 0) {
			final List<WeatherItemsTypeResponse> observation = location.get(0).getObservation();
			if (observation != null && observation.size() > 0) {
				final WeatherItemsTypeResponse weatherItemsTypeResponse = observation.get(0);

				weatheratdestResponse = new WeatheratdestResponse();
				weatheratdestResponse.setDaylight(weatherItemsTypeResponse.getDaylight());
				weatheratdestResponse.setDescription(weatherItemsTypeResponse.getDescription());
				weatheratdestResponse.setTemperature(weatherItemsTypeResponse.getTemperature());

			}
		}

		final EvaluateTravelPoint evaluateTravelPoint = new EvaluateTravelPoint();
		evaluateTravelPoint.setWeatheratdest(weatheratdestResponse);

		return evaluateTravelPoint;
	}

}