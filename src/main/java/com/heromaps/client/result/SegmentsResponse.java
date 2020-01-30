package com.heromaps.client.result;

public class SegmentsResponse {

	private double startinglat;
	private double startinglng;
	private double endinglat;
	private double endinglnf;
	private double distance;
	private double time;

	public double getStartinglat() {
		return startinglat;
	}

	public void setStartinglat(double startinglat) {
		this.startinglat = startinglat;
	}

	public double getStartinglng() {
		return startinglng;
	}

	public void setStartinglng(double startinglng) {
		this.startinglng = startinglng;
	}

	public double getEndinglat() {
		return endinglat;
	}

	public void setEndinglat(double endinglat) {
		this.endinglat = endinglat;
	}

	public double getEndinglnf() {
		return endinglnf;
	}

	public void setEndinglnf(double endinglnf) {
		this.endinglnf = endinglnf;
	}

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

}
