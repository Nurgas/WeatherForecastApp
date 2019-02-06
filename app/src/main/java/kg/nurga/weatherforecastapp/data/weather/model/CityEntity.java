package kg.nurga.weatherforecastapp.data.weather.model;

import com.google.gson.annotations.SerializedName;

public class CityEntity {

        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("country")
        private String countryCode;

        @SerializedName("population")
        private int population;

        public CityEntity(int id, String name, String countryCode, int population) {
            this.id = id;
            this.name = name;
            this.countryCode = countryCode;
            this.population = population;
        }

        public CityEntity() {
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

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }
    }
