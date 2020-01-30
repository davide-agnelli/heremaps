package com.heromaps.client.heromaps_response.calculate_route;

import com.heromaps.client.heromaps_response.weather_conditions.WeatherReportResponse;

public class RouteLegType {

	private WeatherReportResponse start;
	private WeatherReportResponse end;
	private DistanceTypeResponse length;
	private TravelTimeResponse traveltime;
	private RouteSummaryTypeResponse summary;

	public WeatherReportResponse getStart() {
		return start;
	}

	public void setStart(WeatherReportResponse start) {
		this.start = start;
	}

	public WeatherReportResponse getEnd() {
		return end;
	}

	public void setEnd(WeatherReportResponse end) {
		this.end = end;
	}

	public DistanceTypeResponse getLength() {
		return length;
	}

	public void setLength(DistanceTypeResponse length) {
		this.length = length;
	}

	public TravelTimeResponse getTraveltime() {
		return traveltime;
	}

	public void setTraveltime(TravelTimeResponse traveltime) {
		this.traveltime = traveltime;
	}

}
