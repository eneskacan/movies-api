package com.eneskacan.moviesapi.repository;

import com.eneskacan.moviesapi.mapper.MovieMapper;
import com.eneskacan.moviesapi.model.Movie;
import com.eneskacan.moviesapi.util.HttpUtility;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("ImdbRemoteRepository")
public class ImdbRemoteRepository implements IRemoteMovieRepository{

    @Value("${collect.api.token}")
    private String accessToken;

    private static final String BASE_URL = "https://api.collectapi.com/imdb";

    @Override
    public List<Movie> listMovies(String name) {
        List<Movie> movies = new ArrayList<>();

        try {
            String url = String.format("%s/imdbSearchByName?query=%s", BASE_URL, name);
            JSONObject response = HttpUtility.sendGetRequest(url, accessToken);
            if(response.getBoolean("success")) {
                JSONArray array = response.getJSONArray("result");
                for(int i = 0; i < array.length(); i++) {
                    movies.add(MovieMapper.jsonToMovie(array.getJSONObject(i)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }

    @Override
    public Movie getMovie(String id) {
        try {
            String url = String.format("%s/imdbSearchById?movieId=%s", BASE_URL, id);
            JSONObject response = HttpUtility.sendGetRequest(url, accessToken);
            if(response.getBoolean("success")) {
                return MovieMapper.jsonToMovie(response.getJSONObject("result"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
