package com.heromaps.client.heromaps.response.calculate_route;

import java.util.List;

public class RouteTypeResponse {

	private List<RouteLegType> leg;
	private RouteSummaryTypeResponse summary;

	public List<RouteLegType> getLeg() {
		return leg;
	}

	public void setLeg(List<RouteLegType> leg) {
		this.leg = leg;
	}

	public RouteSummaryTypeResponse getSummary() {
		return summary;
	}

	public void setSummary(RouteSummaryTypeResponse summary) {
		this.summary = summary;
	}

}
