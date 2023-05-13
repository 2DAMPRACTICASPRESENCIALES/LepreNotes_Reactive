package com.example.leprenoteReactive.service;

import com.example.leprenoteReactive.domain.Notes;
import com.example.leprenoteReactive.domain.Reviews;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class LepreNotesService {

    static final String BASE_URL = "http://localhost:8081/";
    private LepreNotesAPI api;

    public LepreNotesService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient clientlogger = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        //Objeto Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientlogger) //Logger
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(LepreNotesAPI.class);
    }
    public Observable<Notes> getTotalNotes(){
        return this.api.loadAllNotes().flatMapIterable(notes -> notes);
    }
    public Observable<Reviews> getTotalReviews(){
        return this.api.loadAllReviews().flatMapIterable(reviews -> reviews);
    }

}
