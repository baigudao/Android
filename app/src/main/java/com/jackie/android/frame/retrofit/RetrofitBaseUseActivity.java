package com.jackie.android.frame.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.jackie.android.R;
import com.jackie.android.bean.WeatherInform;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBaseUseActivity extends Activity {

    private TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_base_use);
        ((TextView) findViewById(R.id.tv_title)).setText("Retrofit的基本使用");

        tv_data = (TextView) findViewById(R.id.tv_data);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromNet();
            }
        });
    }

    private void getDataFromNet() {
        //baseUrl用于和之前在Service的Get注解中写的路径拼接成一个完整的url
        //addConverterFactory(GsonConverterFactory.create())可以直接将得到的json数据转换为Service类中Call定义的WeatherInform实体类，完成了json到实体类的自动转换
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("http://op.juhe.cn/onebox/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService mWeatherService = mRetrofit.create(WeatherService.class);
        Call<WeatherInform> mWeatherCall = mWeatherService.getWeather("北京", "json", "19f4708ebed559eac920bbaa51b24a12");
        mWeatherCall.enqueue(new Callback<WeatherInform>() {
            @Override
            public void onResponse(Call<WeatherInform> call, Response<WeatherInform> response) {
                if (response != null) {
                    WeatherInform weatherInform = response.body();//得到请求的数据
                    if (weatherInform != null) {
                        WeatherInform.ResultBean.DataBean.RealtimeBean realtimeBean = weatherInform.getResult().getData().getRealtime();
                        tv_data.setText("当前时间：" + realtimeBean.getDate() + realtimeBean.getTime() + "\n"
                                + realtimeBean.getCity_name() + "\n"
                                + "天气：" + realtimeBean.getWeather().getInfo() + " ； " + realtimeBean.getWeather().getTemperature() + "度");
                    }
                } else {
                    LogUtils.e("onResponse: response is null");
                }
            }

            @Override
            public void onFailure(Call<WeatherInform> call, Throwable t) {
                LogUtils.e("onFailure : " + t.getMessage());
            }
        });
    }
}
