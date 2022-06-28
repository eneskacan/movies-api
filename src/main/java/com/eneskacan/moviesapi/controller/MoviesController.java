package com.eneskacan.moviesapi.controller;

import com.eneskacan.moviesapi.model.Movie;
import com.eneskacan.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> listMoviesByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(movieService.listMovies(name), HttpStatus.OK);
    }

    @PostMapping("/movies/{id}")
    public ResponseEntity<Boolean> saveMovie(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(movieService.saveMovie(id), HttpStatus.CREATED);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(movieService.getMovie(id), HttpStatus.OK);
    }
}
