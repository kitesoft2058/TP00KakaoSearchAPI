package com.kitesoft.tp00kakaosearchapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {

        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("https://dapi.kakao.com");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<String> call = retrofitService.searchData("영화");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data= response.body();
                new AlertDialog.Builder(MainActivity.this).setMessage(data).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void clickBtn2(View view) {

        Gson gson= new GsonBuilder().create();

        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("https://dapi.kakao.com");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit= builder.build();

        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<ApiResponse> call= retrofitService.searchDataByGSON("영화관");
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse= response.body();
                if(apiResponse==null) Toast.makeText(MainActivity.this, "response null", Toast.LENGTH_SHORT).show();
                else{
                    MetaVO meta= apiResponse.meta;
                    List<DocumentVO> documents= apiResponse.documents;

                    StringBuffer buffer= new StringBuffer();
                    buffer.append("총 데이터 개수 : " + meta.total_count +"\n");
                    buffer.append("총 페이지  : " + meta.pageable_count +"\n");
                    buffer.append("마지막페이지 여 : " + meta.is_end +"\n\n");

                    buffer.append(documents.get(0).id+"\n");
                    buffer.append(documents.get(0).place_name+"\n");
                    buffer.append(documents.get(0).category_name+"\n");
                    buffer.append(documents.get(0).phone+"\n");
                    buffer.append(documents.get(0).road_address_name+"\n");
                    buffer.append(documents.get(0).place_url+"\n");
                    buffer.append(documents.get(0).x+"\n");
                    buffer.append(documents.get(0).y+"\n");

                    new AlertDialog.Builder(MainActivity.this).setMessage( buffer.toString() ).show();
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void clickBtn3(View view) {

        Gson gson= new GsonBuilder().create();

        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("https://dapi.kakao.com");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit= builder.build();

        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<ImageApiResponse> call= retrofitService.searchImageByGSON("스우파");
        call.enqueue(new Callback<ImageApiResponse>() {
            @Override
            public void onResponse(Call<ImageApiResponse> call, Response<ImageApiResponse> response) {
                ImageApiResponse apiResponse= response.body();
                if(apiResponse==null) Toast.makeText(MainActivity.this, "response null", Toast.LENGTH_SHORT).show();
                else{
                    ImageMetaVO meta= apiResponse.meta;
                    List<ImageDocumentVO> documents= apiResponse.documents;

                    StringBuffer buffer= new StringBuffer();
                    buffer.append("총 데이터 개수 : " + meta.total_count +"\n");
                    buffer.append("총 페이지  : " + meta.pageable_count +"\n");
                    buffer.append("마지막페이지 여 : " + meta.is_end +"\n\n");

                    buffer.append(documents.get(0).collection+"\n");
                    buffer.append(documents.get(0).thumbnail_url+"\n");
                    buffer.append(documents.get(0).image_url+"\n");
                    buffer.append(documents.get(0).display_sitename+"\n");
                    buffer.append(documents.get(0).doc_url+"\n");
                    buffer.append(documents.get(0).datetime+"\n");

                    new AlertDialog.Builder(MainActivity.this).setMessage( buffer.toString() ).show();
                }

            }

            @Override
            public void onFailure(Call<ImageApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}