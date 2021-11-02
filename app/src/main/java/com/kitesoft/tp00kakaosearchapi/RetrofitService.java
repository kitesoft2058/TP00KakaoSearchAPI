package com.kitesoft.tp00kakaosearchapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitService {

    @Headers("Authorization: KakaoAK 5d8600b361edf43f0c0501ab9afc8f68")
    @GET("/v2/local/search/keyword.json")
    Call<String> searchData(@Query("query") String query);


    @Headers("Authorization: KakaoAK 5d8600b361edf43f0c0501ab9afc8f68")
    @GET("/v2/local/search/keyword.json")
    Call<ApiResponse> searchDataByGSON(@Query("query") String query);



    @Headers("Authorization: KakaoAK 5d8600b361edf43f0c0501ab9afc8f68")
    @GET("/v2/search/image")
    Call<ImageApiResponse> searchImageByGSON(@Query("query") String query);
}
