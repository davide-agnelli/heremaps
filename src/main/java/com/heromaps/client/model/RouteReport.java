package com.heromaps.client.model;

import com.heromaps.client.result.SegmentsResponse;

import java.util.List;

public class RouteReport {

	private double distance;
	private double time;
	private List<SegmentsResponse> segments;

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

}
