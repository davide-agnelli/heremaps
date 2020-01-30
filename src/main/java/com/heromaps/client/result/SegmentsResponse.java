package com.heromaps.client.result;

public class SegmentsResponse {

	private float startinglat;
	private float startinglng;
	private float endinglat;
	private float endinglnf;
	private float distance;
	private long time;

	public float getStartinglat() {
		return startinglat;
	}

	public void setStartinglat(float startinglat) {
		this.startinglat = startinglat;
	}

	public float getStartinglng() {
		return startinglng;
	}

	public void setStartinglng(float startinglng) {
		this.startinglng = startinglng;
	}

	public float getEndinglat() {
		return endinglat;
	}

	public void setEndinglat(float endinglat) {
		this.endinglat = endinglat;
	}

	public float getEndinglnf() {
		return endinglnf;
	}

	public void setEndinglnf(float endinglnf) {
		this.endinglnf = endinglnf;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
