package com.chris.life.pages.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.chris.life.R;
import com.chris.life.api.common.JuheApisResponse;
import com.chris.life.api.weather.WeatherApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {
    private TextView tvCityName, tvWeatherInfo, tvDirect, tvTemperature, tvHumidity, tvPower, tvAqi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_weather);

        initView();
    }

    private void initView() {
        tvCityName = findViewById(R.id.tv_weather_city_name);
        tvWeatherInfo = findViewById(R.id.tv_weather_info);
        tvDirect = findViewById(R.id.tv_weather_direct);
        tvTemperature = findViewById(R.id.tv_weather_temperature);
        tvHumidity = findViewById(R.id.tv_weather_humidity);
        tvPower = findViewById(R.id.tv_weather_power);
        tvAqi = findViewById(R.id.tv_weather_aqi);

        WeatherApi.getWeatherInfo("上海", new Callback<JuheApisResponse<WeatherInfo>>() {
            @Override
            public void onResponse(Call<JuheApisResponse<WeatherInfo>> call, Response<JuheApisResponse<WeatherInfo>> response) {
                WeatherInfo weatherInfo = response.body().getResult();
                tvCityName.setText("城市: " + weatherInfo.city);
                tvWeatherInfo.setText("天气: " + weatherInfo.realtime.info);
                tvDirect.setText("风向: " + weatherInfo.realtime.direct);
                tvPower.setText("风力: " + weatherInfo.realtime.power);
                tvTemperature.setText("气温: " + weatherInfo.realtime.temperature);
                tvHumidity.setText("湿度: " + weatherInfo.realtime.humidity);
                tvAqi.setText("空气质量指数: " + weatherInfo.realtime.aqi);
            }

            @Override
            public void onFailure(Call<JuheApisResponse<WeatherInfo>> call, Throwable t) {

            }
        });

    }
}
