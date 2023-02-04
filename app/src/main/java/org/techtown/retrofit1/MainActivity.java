package org.techtown.retrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.techtown.retrofit1.model.BoxOfficeResult;
import org.techtown.retrofit1.model.DailyBoxOfficeList;
import org.techtown.retrofit1.model.MyPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//test
public class MainActivity extends AppCompatActivity {

    final String BASE_URL = "http://www.kobis.or.kr/"; //기본 URL
    Retrofit retrofit;
    RetrofitAPI retrofitAPI;
    String API_KEY = "38c6ceb4a7eeff3b3eecedf0fe9beff2";

    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();


        //retrofit 객체 생성
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        /*addConverterFactory(GsonConverterFactory.create())은
    Json을 우리가 원하는 형태로 만들어주는 Gson라이브러리와 Retrofit2에 연결하는 코드입니다 */

        retrofitAPI = retrofit.create(RetrofitAPI.class);
                                            //최종적으로 붙는..
        retrofitAPI.getBoxOfficeResult(API_KEY, "20150101").enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {
                if(response.isSuccessful()) {
                    MyPojo result = response.body();
                    DailyBoxOfficeList[] dailyBoxOfficeList = result.getBoxOfficeResult().getDailyBoxOfficeList();
                    tv1.setText(dailyBoxOfficeList.toString());


                }

            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Toast.makeText(MainActivity.this,call.toString(),Toast.LENGTH_SHORT).show();


            }
        });
    }



    private void setViews() {
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
    }
}