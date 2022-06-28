package com.eneskacan.moviesapi.repository;

import com.eneskacan.moviesapi.model.Movie;

import java.util.List;

public interface IRemoteMovieRepository {

    List<Movie> listMovies(String name);
    Movie getMovie(String id);
}
