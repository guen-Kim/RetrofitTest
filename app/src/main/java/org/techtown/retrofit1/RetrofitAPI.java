package org.techtown.retrofit1;

import com.google.android.material.internal.ManufacturerUtils;

import org.techtown.retrofit1.model.MyPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {

 //	기본 요청 URL : http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml (또는 .json)
    ///kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json") //호출주소
    Call<MyPojo> getBoxOfficeResult(@Query("key") String key,@Query("targetDt") String targetDt);

}
