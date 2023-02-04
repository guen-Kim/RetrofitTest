package org.techtown.app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.techtown.app2.adapter.MovieAdapter;
import org.techtown.app2.model.BoxOfficeResult;
import org.techtown.app2.model.DailyBoxOfficeList;
import org.techtown.app2.model.MyPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RetrofitService retrofitService;
    String API_KEY = "f5eef3421c602c6cb7ea224104795888";

    List<DailyBoxOfficeList> movieData;
    MovieAdapter adapter;
    RecyclerView recyclerView;
    Button btn;
    TextInputEditText tietdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieData = new ArrayList<>();
        setupViews();

        retrofitService = WebServiceClient.getInstance().getService();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date = tietdate.getText().toString();

                Call<MyPojo> call = retrofitService.getBoxOfficeResult(API_KEY,date);
                call.enqueue(new Callback<MyPojo>() {
                    @Override
                    public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {

                        // PostResult 객체로 변환 성공
                        MyPojo result = response.body();
                        BoxOfficeResult resultBox =  result.getBoxOfficeResult();
                        DailyBoxOfficeList[] newDailylist = resultBox.getDailyBoxOfficeList();

                        for(DailyBoxOfficeList movie : newDailylist)
                        {
                            movieData.add(movie);
                        }
                        adapter = new MovieAdapter(MainActivity.this);
                        adapter.datasetChanged(movieData);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<MyPojo> call, Throwable t) {


                    }
                });
            }
        });



    }

    private void setupViews() {
        recyclerView = findViewById(R.id.ryScrollView);
        btn = findViewById(R.id.btn);
        tietdate = findViewById(R.id.tietdate);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}


