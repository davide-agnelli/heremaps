package com.heromaps.client.heromaps.service;

import com.heromaps.client.heromaps.response.calculate_route.CalculateRouteResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface CalculateRouteInterface {


	@GET("calculateroute.json")
	Call<CalculateRouteResponse> listRepos(@Query("waypoint") List<String> waypoint, @Query("mode") String mode);

}