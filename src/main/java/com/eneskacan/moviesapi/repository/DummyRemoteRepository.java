package com.eneskacan.moviesapi.repository;

import com.eneskacan.moviesapi.mapper.MovieMapper;
import com.eneskacan.moviesapi.model.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
@Qualifier("DummyRemoteRepository")
public class DummyRemoteRepository implements IRemoteMovieRepository {

    private static final String MOVIE_1 = "tt1375666,Inception,2010,movie,ttps://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg";
    private static final String MOVIE_2 = "tt1375643,Interstellar,2010,movie,ttps://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX301.jpg";

    @Override
    public List<Movie> listMovies(String name) {
        return List.of(MovieMapper.csvToMovie(MOVIE_1), MovieMapper.csvToMovie(MOVIE_2)).stream()
                .filter(movie -> movie.getTitle().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    @Override
    public Movie getMovie(String id) {
        if(id.toLowerCase(Locale.ROOT).equals("tt1375666"))
            return MovieMapper.csvToMovie(MOVIE_1);

        return MovieMapper.csvToMovie(MOVIE_2);
    }
}
