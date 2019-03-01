package kg.nurga.weatherforecastapp.data.weather.remote;

import android.util.Log;

import kg.nurga.core.GetRetrofit;
import kg.nurga.weatherforecastapp.data.weather.WeatherDataSource;
import kg.nurga.weatherforecastapp.data.weather.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRemoteDataSource implements WeatherDataSource {

    public WeatherNetworkClient mClient = GetRetrofit.getRetrofit(WeatherRemoteConfig.API_URL)
            .create(WeatherNetworkClient.class);

    @Override
    public void getWeather(final WeatherCallback callback) {

        Call<WeatherResponse> call = mClient.getWeather(
                "Bishkek,kg",
                WeatherRemoteConfig.API_KEY,
                "ru",
                "metric"
        );

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d("Response", call.request().url().toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        callback.onSuccess(response.body());
                    } else {
                        callback.onFailure();
                    }
                } else {
                    callback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("Fail", "Failure " + t.getMessage());
                callback.onFailure();
            }
        });
    }

}
