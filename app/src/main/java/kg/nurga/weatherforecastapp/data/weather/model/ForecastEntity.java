package kg.nurga.weatherforecastapp.data.weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastEntity {

    @SerializedName("dt")
    private long timestamp;

    @SerializedName("main")
    private ForecastMainEntity mainData;

    @SerializedName("weather")
    private List<ForecastWeatherType> weatherTypes;

    public ForecastEntity(
            long timestamp,
            ForecastMainEntity mainData,
            List<ForecastWeatherType> weatherTypes) {
        this.timestamp = timestamp;
        this.mainData = mainData;
        this.weatherTypes = weatherTypes;
    }

    public ForecastEntity() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ForecastMainEntity getMainData() {
        return mainData;
    }

    public void setMainData(ForecastMainEntity mainData) {
        this.mainData = mainData;
    }

    public List<ForecastWeatherType> getWeatherTypes() {
        return weatherTypes;
    }

    public void setWeatherTypes(List<ForecastWeatherType> weatherTypes) {
        this.weatherTypes = weatherTypes;
    }
}
