package com.heromaps.client.result;

import java.util.List;

public class EvaluateTravelPoint {

	private double distance;
	private double time;
	private List<SegmentsResponse> segments;
	private WeatheratdestResponse weatheratdest;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public List<SegmentsResponse> getSegments() {
		return segments;
	}

	public void setSegments(List<SegmentsResponse> segments) {
		this.segments = segments;
	}

	public WeatheratdestResponse getWeatheratdest() {
		return weatheratdest;
	}

	public void setWeatheratdest(WeatheratdestResponse weatheratdest) {
		this.weatheratdest = weatheratdest;
	}

}
