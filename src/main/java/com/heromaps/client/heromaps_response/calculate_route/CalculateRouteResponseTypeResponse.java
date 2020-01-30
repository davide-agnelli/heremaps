package com.heromaps.client.heromaps_response.calculate_route;

public class CalculateRouteResponseTypeResponse {

	private RouteResponseMetaInfoType metaInfo;
	private RouteResponse route;

	public RouteResponseMetaInfoType getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(RouteResponseMetaInfoType metaInfo) {
		this.metaInfo = metaInfo;
	}

	public RouteResponse getRoute() {
		return route;
	}

	public void setRoute(RouteResponse route) {
		this.route = route;
	}

}
