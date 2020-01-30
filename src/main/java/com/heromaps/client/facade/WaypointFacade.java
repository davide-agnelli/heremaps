package com.heromaps.client.facade;

import com.heromaps.client.dto.RouteDTO;
import com.heromaps.client.model.RouteReport;
import com.heromaps.client.result.EvaluateTravelPoint;
import com.heromaps.client.service.CalculateReportRouteService;
import com.heromaps.client.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WaypointFacade {

	@Autowired
	private WeatherReportService weatherReportService;

	@Autowired
	private CalculateReportRouteService calculateReportRouteService;

	public EvaluateTravelPoint calculate(RouteDTO route) throws IOException {
		final EvaluateTravelPoint evaluateTravelPoint = new EvaluateTravelPoint();

		final RouteReport routeReport = calculateReportRouteService.calculateRoute(route.waypoints);
		evaluateTravelPoint.setSegments(routeReport.getSegments());
		evaluateTravelPoint.setDistance(routeReport.getDistance());
		evaluateTravelPoint.setTime(routeReport.getTime());
		evaluateTravelPoint.setWeatheratdest(weatherReportService.getWeatherReport(route.waypoints));
		return evaluateTravelPoint;
	}

}