package org.techtown.app2;

import android.os.Debug;
import android.util.Log;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * singleton
 * Retrofit 환경설정
 *
 * */


public class WebServiceClient {
    private static final String TAG = WebServiceClient.class.getSimpleName();

    private static WebServiceClient instance = new WebServiceClient();

    private final RetrofitService services;

    public static WebServiceClient getInstance(){
        return instance;
    }

    private WebServiceClient() {

        //gson 생성 및 환경설정
//        final Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .create();

        // retrofit 생성 및 환경설정
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("http://www.kobis.or.kr/")
                .addConverterFactory(GsonConverterFactory.create()); //json 변환기 gson 설정

        if (Debug.isDebuggerConnected()) // 디버거가 연결되어 있다면
        {
            final HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.d(TAG, message);
                        }
                    });


            retrofitBuilder.callFactory(new OkHttpClient
                    .Builder()
                    .addNetworkInterceptor(loggingInterceptor)
                    .build());

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        // retrofit은 인터페이스(RetrofitService) 구현체
        services = retrofitBuilder.build().create(RetrofitService.class);

    }
    public RetrofitService getService() {
        return services;
    }

}
