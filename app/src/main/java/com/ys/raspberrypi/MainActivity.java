package com.ys.raspberrypi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hzlc4i6jra.execute-api.us-west-2.amazonaws.com/")
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SubmitService service = retrofit.create(SubmitService.class);

        JSONObject obj = new JSONObject();
        try {
            obj.put("os", "android");
            obj.put("token","test1234567");
            Call<JSONObject> call = service.getobj(obj);
            call.enqueue(new Callback<JSONObject>() {
                @Override
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                    Log.d("aaa", response.toString());
                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {
                    Log.d("aaa",t.toString());
                }
            });
        }catch (Exception e){
            Log.d("aaa",e.toString());
        }


    }
}
