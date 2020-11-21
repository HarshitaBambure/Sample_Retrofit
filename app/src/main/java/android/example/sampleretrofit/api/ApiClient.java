package android.example.sampleretrofit.api;

import android.example.sampleretrofit.Constatant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constatant.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    }