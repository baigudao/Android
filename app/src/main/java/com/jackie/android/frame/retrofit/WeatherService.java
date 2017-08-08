package com.jackie.android.frame.retrofit;

import com.jackie.android.bean.WeatherInform;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jackie on 2017/8/8 15:07.
 * QQ : 971060378
 * Used as : xxx
 */
public interface WeatherService {

    //用于指定请求的方式
    @GET("weather/query")
    //具体的请求回调的方法，可以使用@Query注解来添加url中的参数
    Call<WeatherInform> getWeather(@Query("cityname") String cityname, @Query("dtype") String dtype, @Query("key") String key);

}
