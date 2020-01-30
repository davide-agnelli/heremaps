package com.heromaps.client.service;

import com.heromaps.client.heromaps_response.weather_conditions.WeatherReportResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherConditionsInterface {

	@GET("report.json")
	Call<WeatherReportResponse> weatherReport(@Query("product") String product,
	                                          @Query("latitude") float latitude,
	                                          @Query("longitude") float longitude,
	                                          @Query("oneobservation") boolean oneobservation);

}