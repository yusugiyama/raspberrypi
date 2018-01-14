package com.ys.raspberrypi;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

/**
 * Created by oremo on 2018/01/11.
 */

public interface SubmitService {
    @HTTP(method = "POST", path = "/prod/env/", hasBody = true)
    Call<JSONObject> getobj(@Body JSONObject id);

}
