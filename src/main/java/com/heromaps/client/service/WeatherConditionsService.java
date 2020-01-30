package com.heromaps.client.service;

import com.heromaps.client.heromaps_response.weather_conditions.WeatherReportResponse;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class WeatherConditionsService implements APIConfiguration {

	private static final String WEATHER_BASE_URL = "https://weather.ls.hereapi.com/weather/1.0/";
	private static final String PRODUCT = "observation";
	private static final boolean ONEOBSERVATION = true;

	private WeatherConditionsInterface service;

	public WeatherConditionsService() {
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.addInterceptor(chain -> {
					Request original = chain.request();
					HttpUrl httpUrl = original.url();

					HttpUrl newHttpUrl1 = httpUrl.newBuilder().addQueryParameter("apiKey", API_KEY).build();

					Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl1);

					Request request = requestBuilder.build();

					return chain.proceed(request);
				}).build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(WEATHER_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(okHttpClient)
				.build();

		service = retrofit.create(WeatherConditionsInterface.class);
	}

	public WeatherReportResponse weatherReport(float latitude, float longitude) throws IOException {
		Call<WeatherReportResponse> retrofitCall = service.weatherReport(PRODUCT, latitude, longitude, ONEOBSERVATION);

		Response<WeatherReportResponse> response = retrofitCall.execute();

		if (!response.isSuccessful()) {
			throw new IOException(response.errorBody() != null
					? response.errorBody().string() : "Unknown error");
		}

		return response.body();
	}

}
