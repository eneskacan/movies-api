package com.eneskacan.moviesapi.service;

import com.eneskacan.moviesapi.model.Movie;
import com.eneskacan.moviesapi.repository.ILocalMovieRepository;
import com.eneskacan.moviesapi.repository.IRemoteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final ILocalMovieRepository localRepository;
    private final IRemoteMovieRepository remoteRepository;

    @Autowired
    public MovieService(ILocalMovieRepository localRepository,
                        @Qualifier("ImdbRemoteRepository") IRemoteMovieRepository remoteRepository) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
    }

    public List<Movie> listMovies(String name) {
        return remoteRepository.listMovies(name);
    }

    public Movie getMovie(String id) {
        // First check if movie exist in local
        if(localRepository.getMovie(id) != null)
            return localRepository.getMovie(id);

        // If not, get it from remote source
        return remoteRepository.getMovie(id);
    }

    public boolean saveMovie(String id) {
        Movie movie = remoteRepository.getMovie(id);
        return localRepository.saveMovie(movie);
    }
}
