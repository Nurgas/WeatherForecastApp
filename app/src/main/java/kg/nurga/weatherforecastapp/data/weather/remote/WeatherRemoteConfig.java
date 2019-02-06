package kg.nurga.weatherforecastapp.data.weather.remote;

import kg.nurga.weatherforecastapp.BuildConfig;

public class WeatherRemoteConfig {
    static final String API_URL = "https://api.openweathermap.org";
    private static final String API_DATA = "/data";
    private static final String VERSION = "/2.5";
    static final String FORECAST_URL = API_DATA + VERSION + "/forecast";
    static final String API_KEY = BuildConfig.API_KEY;
}
