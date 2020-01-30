package com.heromaps.client.result;

import java.util.List;

public class EvaluateTravelPoint {

	private Float distance;
	private long time;
	private List<SegmentsResponse> segments;
	private WeatheratdestResponse weatheratdest;

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
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
