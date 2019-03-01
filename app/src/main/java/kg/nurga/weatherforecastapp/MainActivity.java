package kg.nurga.weatherforecastapp;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.PhantomReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import kg.nurga.weatherforecastapp.data.weather.WeatherDataSource;
import kg.nurga.weatherforecastapp.data.weather.model.ForecastEntity;
import kg.nurga.weatherforecastapp.data.weather.model.ForecastMainEntity;
import kg.nurga.weatherforecastapp.data.weather.model.WeatherResponse;
import kg.nurga.weatherforecastapp.data.weather.remote.WeatherRemoteDataSource;
import kg.nurga.weatherforecastapp.recycler.WeatherAdapter;

public class MainActivity extends AppCompatActivity {
    private TextView cityName;
    private Button mButton;
    List<ForecastMainEntity> mForecastEntityList;
    WeatherAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                initList();
    }
    private void initList(){
        mForecastEntityList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new WeatherAdapter(mForecastEntityList);
        recyclerView.setAdapter(mAdapter);

        showTemp();

    }

    private void showTemp() {
        new WeatherRemoteDataSource().getWeather(new WeatherDataSource.WeatherCallback() {
                    @Override
                    public void onSuccess(WeatherResponse result) {

                        for (ForecastEntity forecast : result.getForecast()) {
                            long time = forecast.getTimestamp()*1000;
                            Calendar cal = Calendar.getInstance();
                            cal.setTimeInMillis(time);
                            Date date = new Date(time);
                            DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String formatted = format.format(date);

                            mForecastEntityList.add(forecast.getMainData());
                            mAdapter.notifyDataSetChanged();

                            Log.d("TimeWeather", "Forecast time " + formatted);
                        }
                    }

                    @Override
                    public void onFailure() {
                        Log.d("Fail", "Failure");
                    }
                });
    }

}
