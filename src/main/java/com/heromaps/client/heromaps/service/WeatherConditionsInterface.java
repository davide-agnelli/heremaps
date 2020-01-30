package com.heromaps.client.heromaps.service;

import com.heromaps.client.heromaps.response.weather_conditions.WeatherReportResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherConditionsInterface {

	@GET("report.json")
	Call<WeatherReportResponse> weatherReport(@Query("product") String product,
	                                          @Query("latitude") double latitude,
	                                          @Query("longitude") double longitude,
	                                          @Query("oneobservation") boolean oneobservation);

}