package com.heromaps.client.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface CalculateRouteInterface {

	//FIX ME
	@GET("calculateroute.json")
	Call<Object> listRepos(@Query("waypoint") List<String> waypoint, @Query("mode") String mode);

}