package org.techtown.app2;

import org.techtown.app2.model.MyPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json") //호출주소
    Call<MyPojo> getBoxOfficeResult(@Query("key") String key, @Query("targetDt") String targetDt);



//    @GET("posts/{post}")
//    Call<PostResult> getPosts(@Path("post") String post);
}
