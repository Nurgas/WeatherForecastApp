package kg.nurga.weatherforecastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kg.nurga.weatherforecastapp.data.weather.WeatherDataSource;
import kg.nurga.weatherforecastapp.data.weather.model.ForecastEntity;
import kg.nurga.weatherforecastapp.data.weather.model.WeatherResponse;
import kg.nurga.weatherforecastapp.data.weather.remote.WeatherRemoteDataSource;

public class MainActivity extends AppCompatActivity {
    private TextView cityName;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.city_name);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WeatherRemoteDataSource()
                        .getWeather(new WeatherDataSource.WeatherCallback() {
                            @Override
                            public void onSuccess(WeatherResponse result) {
                                Log.d("Weather", "Success " + result.getCode() +
                                        " " + result.getCount() + " " + result.getCity().getName());

                                for (ForecastEntity forecast : result.getForecast()) {
                                    long time = forecast.getTimestamp();

                                    String weather = forecast.getWeatherTypes().get(0).getDescription();
                                    Log.d("Pogoda", "Weather " + weather);

                                    Calendar cal = Calendar.getInstance();
                                    cal.setTimeInMillis(time);
//                                    Log.d("TimeWeather", "Forecast time " + cal.getTime());

                                    Date date = new Date(time);
                                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    String formatted = format.format(date);
                                    Log.d("TimeWeather", "Forecast time " + formatted);
                                }
                            }

                            @Override
                            public void onFailure() {
                                Log.d("ololo", "Failure");
                            }
                        });
            }
        });
    }
}
