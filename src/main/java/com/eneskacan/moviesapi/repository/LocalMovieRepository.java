package com.eneskacan.moviesapi.repository;

import com.eneskacan.moviesapi.mapper.MovieMapper;
import com.eneskacan.moviesapi.model.Movie;
import com.eneskacan.moviesapi.util.FileReaderUtil;
import com.eneskacan.moviesapi.util.FileWriterUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public class LocalMovieRepository implements ILocalMovieRepository{

    @Value("${local.storage.file}")
    private String filePath;

    @Override
    public Movie getMovie(String id) {
        return FileReaderUtil.readFile(filePath).stream()
                .map(MovieMapper::csvToMovie)
                .filter(movie -> movie.getImdbId().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean saveMovie(Movie movie) {
        if(movie == null) return false; // Return false if movie is null
        if(getMovie(movie.getImdbId()) != null) return true; // Don't save movies twice

        return FileWriterUtil.writeToFile(MovieMapper.movieToCsv(movie), filePath);
    }
}
