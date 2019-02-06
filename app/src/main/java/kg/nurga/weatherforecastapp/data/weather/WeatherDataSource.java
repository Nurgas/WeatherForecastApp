package kg.nurga.weatherforecastapp.data.weather;

import kg.nurga.weatherforecastapp.data.weather.model.WeatherResponse;

public interface WeatherDataSource {
    void getWeather(WeatherCallback callback);

    interface WeatherCallback {
        void onSuccess(WeatherResponse result);

        void onFailure();
    }

}
