package kg.nurga.weatherforecastapp.data.weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    @SerializedName("cod")
    private String code;

    @SerializedName("cnt")
    private int count;

    @SerializedName("list")
    private List<ForecastEntity> forecast;

    @SerializedName("city")
    private CityEntity city;

    public WeatherResponse(
            String code,
            int count,
            List<ForecastEntity> forecast,
            CityEntity city) {
        this.code = code;
        this.count = count;
        this.forecast = forecast;
        this.city = city;
    }

    public WeatherResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ForecastEntity> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastEntity> forecast) {
        this.forecast = forecast;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
