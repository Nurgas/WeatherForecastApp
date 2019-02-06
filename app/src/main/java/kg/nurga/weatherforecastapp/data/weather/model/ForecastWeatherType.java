package kg.nurga.weatherforecastapp.data.weather.model;

import com.google.gson.annotations.SerializedName;

public class ForecastWeatherType {
    @SerializedName("id")
    private int id;

    @SerializedName("main")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String iconId;

    public ForecastWeatherType(int id, String name, String description, String iconId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.iconId = iconId;
    }

    public ForecastWeatherType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }
}

