package com.heromaps.client.heromaps.service;

import com.heromaps.client.heromaps.response.calculate_route.CalculateRouteResponse;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class CalculateRouteService implements APIConfiguration {

	private static final String CALCULATE_ROUTE_BASE_URL = "https://route.ls.hereapi.com/routing/7.2/";
	private final String MODE = "fastest;car";

	private CalculateRouteInterface service;

	public CalculateRouteService() {
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.addInterceptor(chain -> {
					Request original = chain.request();
					HttpUrl httpUrl = original.url();

					HttpUrl newHttpUrl1 = httpUrl.newBuilder().addQueryParameter("apiKey", API_KEY).build();

					Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl1);

					Request request = requestBuilder.build();

					return chain.proceed(request);
				})
				.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(CALCULATE_ROUTE_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(okHttpClient)
				.build();

		service = retrofit.create(CalculateRouteInterface.class);
	}

	public CalculateRouteResponse getRoute(List<String> waypoint) throws IOException {
		Call<CalculateRouteResponse> retrofitCall = service.listRepos(waypoint, MODE);

		Response<CalculateRouteResponse> response = retrofitCall.execute();

		if (!response.isSuccessful()) {
			throw new IOException(response.errorBody() != null
					? response.errorBody().string() : "Unknown error");
		}

		return response.body();
	}

}
