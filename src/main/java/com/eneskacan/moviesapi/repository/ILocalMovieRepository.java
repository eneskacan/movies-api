package com.eneskacan.moviesapi.repository;

import com.eneskacan.moviesapi.model.Movie;

public interface ILocalMovieRepository {

    Movie getMovie(String id);
    boolean saveMovie(Movie movie);
}
