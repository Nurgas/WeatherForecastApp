package kg.nurga.weatherforecastapp.data.weather.remote;

import kg.nurga.weatherforecastapp.data.weather.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherNetworkClient {

        @GET(WeatherRemoteConfig.FORECAST_URL)
        Call<WeatherResponse> getWeather(
                @Query("q") String city,
                @Query("APPID") String apiKey,
                @Query("lang") String language,
                @Query("units") String units
        );

    }
