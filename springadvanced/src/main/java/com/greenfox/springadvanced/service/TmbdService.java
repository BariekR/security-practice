package com.greenfox.springadvanced.service;

import com.greenfox.springadvanced.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TmbdService {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1YTRlYmNkMTFmNzNkODRkMzhhNWY1NDU4NWM5ZTFlZCIsInN1YiI6IjY1NmYxMmRlM2RjMzEzMDEzODdiYTQxYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tENC7QtYEbCbBDA_u0tKwQ1nd2advx9Ub26uYenfBfI")
    @GET("3/movie/{movieId}")
    Call<Movie> getMovie(@Path("movieId") Long id);
}
