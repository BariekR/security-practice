package com.greenfox.springadvanced.service;

import com.greenfox.springadvanced.model.Movie;
import com.greenfox.springadvanced.repository.MovieRepository;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final TmbdService tmbdService;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tmbdService = retrofit.create(TmbdService.class);
    }

    public void saveRequestedMovie(Long movieId) throws IOException {
        Call<Movie> movieCall = tmbdService.getMovie(movieId);
        Response<Movie> movieResponse = movieCall.execute();

        if (movieResponse.isSuccessful() && movieResponse.body() != null) {
            movieRepository.save(movieResponse.body());
        }
    }

    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }
}
