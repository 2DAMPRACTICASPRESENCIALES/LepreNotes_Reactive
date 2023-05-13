package com.example.leprenoteReactive.service;

import com.example.leprenoteReactive.domain.Notes;
import com.example.leprenoteReactive.domain.Reviews;
import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface LepreNotesAPI {

    @GET("notes")
    Observable<List<Notes>> loadAllNotes();
    @GET("reviews")
    Observable<List<Reviews>> loadAllReviews();
}
