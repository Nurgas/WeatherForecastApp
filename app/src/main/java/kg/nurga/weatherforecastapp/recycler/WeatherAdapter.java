package kg.nurga.weatherforecastapp.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kg.nurga.weatherforecastapp.R;
import kg.nurga.weatherforecastapp.data.weather.model.ForecastEntity;
import kg.nurga.weatherforecastapp.data.weather.model.ForecastMainEntity;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder>{


    private List<ForecastMainEntity> listTemp;

    public WeatherAdapter(List<ForecastMainEntity> listTemp) {
        this.listTemp = listTemp;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_forecast, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ForecastMainEntity forecastEntity = listTemp.get(i);
        myViewHolder.mTextTitle.setText(String.valueOf(forecastEntity.getTemperature()));
    }

    @Override
    public int getItemCount() {

        return listTemp.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextTitle;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            mTextTitle = itemView.findViewById(R.id.textTitle);
        }
    }
}
