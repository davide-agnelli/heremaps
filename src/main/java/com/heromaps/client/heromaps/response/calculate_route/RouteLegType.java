package com.heromaps.client.heromaps.response.calculate_route;

import java.util.List;

public class RouteLegType {

	private WaypointTypeResponse start;
	private WaypointTypeResponse end;
	private double travelTime;
	private double length;
	private List<ManeuverTypeResponse> maneuver;

	public WaypointTypeResponse getStart() {
		return start;
	}

	public void setStart(WaypointTypeResponse start) {
		this.start = start;
	}

	public WaypointTypeResponse getEnd() {
		return end;
	}

	public void setEnd(WaypointTypeResponse end) {
		this.end = end;
	}

	public double getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(double travelTime) {
		this.travelTime = travelTime;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public List<ManeuverTypeResponse> getManeuver() {
		return maneuver;
	}

	public void setManeuver(List<ManeuverTypeResponse> maneuver) {
		this.maneuver = maneuver;
	}

}
