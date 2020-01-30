package com.heromaps.client.service;

import com.heromaps.client.dto.WaypointDTO;
import com.heromaps.client.heromaps.response.calculate_route.CalculateRouteResponse;
import com.heromaps.client.heromaps.response.calculate_route.GeoCoordinateTypeResponse;
import com.heromaps.client.heromaps.response.calculate_route.RouteLegType;
import com.heromaps.client.heromaps.response.calculate_route.RouteSummaryTypeResponse;
import com.heromaps.client.heromaps.response.calculate_route.RouteTypeResponse;
import com.heromaps.client.heromaps.service.CalculateRouteService;
import com.heromaps.client.model.RouteReport;
import com.heromaps.client.result.SegmentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculateReportRouteService {

	@Autowired
	private CalculateRouteService calculateRouteService;

	public RouteReport calculateRoute(List<WaypointDTO> waypoints) throws IOException {

		List<String> waypointList = new ArrayList<>();

		for (WaypointDTO waypoint : waypoints) {

			final StringBuilder sb = new StringBuilder();
			sb.append(waypoint.lat);
			sb.append(",");
			sb.append(waypoint.lng);

			waypointList.add(sb.toString());
		}

		final CalculateRouteResponse calculateRouteResponse = calculateRouteService.getRoute(waypointList);

		//Validate if weather report response is valid
		final List<RouteTypeResponse> route = calculateRouteResponse.getResponse().getRoute();
		if (route == null || route.size() > 1) {
			throw new IllegalStateException();
		}

		final RouteTypeResponse routeTypeResponse = route.get(0);
		final RouteSummaryTypeResponse summary = routeTypeResponse.getSummary();

		final RouteReport routeReport = new RouteReport();
		routeReport.setDistance(summary.getDistance());
		routeReport.setTime(summary.getBaseTime());
		routeReport.setSegments(convertRouteTypeResponseToSegments(routeTypeResponse.getLeg()));

		return routeReport;
	}

	/**
	 * Convert List<WaypointDTO> in List<String> for calculate route
	 *
	 * @param waypoints
	 * @return
	 */
	private List<String> waypointRequest(List<WaypointDTO> waypoints) {
		List<String> waypointRequests = new ArrayList<>();

		for (WaypointDTO waypoint : waypoints) {

			final StringBuilder sb = new StringBuilder();
			sb.append(waypoint.lat);
			sb.append(",");
			sb.append(waypoint.lng);
			waypointRequests.add(sb.toString());
		}

		return waypointRequests;
	}

	/**
	 * Convert List<RouteLegType> to List<SegmentsResponse>
	 * @param routeLegTypes
	 * @return
	 */
	private List<SegmentsResponse> convertRouteTypeResponseToSegments(List<RouteLegType> routeLegTypes){

		final List<SegmentsResponse> segmentsResponses = new ArrayList<>();

		for (RouteLegType routeLegType : routeLegTypes) {

			SegmentsResponse segmentsResponse = new SegmentsResponse();

			final GeoCoordinateTypeResponse startPosition = routeLegType.getStart().getOriginalPosition();
			segmentsResponse.setStartinglat(startPosition.getLatitude());
			segmentsResponse.setStartinglng(startPosition.getLongitude());

			final GeoCoordinateTypeResponse endPosition = routeLegType.getEnd().getOriginalPosition();
			segmentsResponse.setEndinglat(endPosition.getLatitude());
			segmentsResponse.setEndinglnf(endPosition.getLongitude());

			segmentsResponse.setDistance(routeLegType.getLength());
			segmentsResponse.setTime(routeLegType.getTravelTime());

			segmentsResponses.add(segmentsResponse);
		}

		return segmentsResponses;
	}

}
