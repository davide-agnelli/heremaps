package com.heromaps.client.heromaps.response.calculate_route;

public class ManeuverTypeResponse {

	private GeoCoordinateTypeResponse position;
	private double travelTime;
	private double length;

	public GeoCoordinateTypeResponse getPosition() {
		return position;
	}

	public void setPosition(GeoCoordinateTypeResponse position) {
		this.position = position;
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

}
