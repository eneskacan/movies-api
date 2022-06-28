package com.eneskacan.moviesapi.mapper;

import com.eneskacan.moviesapi.model.Movie;
import org.json.JSONException;
import org.json.JSONObject;

public final class MovieMapper {

    private MovieMapper() {
        throw new IllegalStateException("Utility class");
    }

    // Transforms coma separated values to Movie object
    public static Movie csvToMovie(String csv) {
        String[] values = csv.split(",");

        return Movie.builder()
                .imdbId(values[0])
                .title(values[1])
                .year(Integer.parseInt(values[2]))
                .type(values[3])
                .poster(values[4])
                .build();
    }

    // Transforms JSON object to Movie object
    public static Movie jsonToMovie(JSONObject json) throws JSONException {
        return Movie.builder()
                .imdbId(json.getString("imdbID"))
                .title(json.getString("Title"))
                .year(Integer.parseInt(json.getString("Year")))
                .type(json.getString("Type"))
                .poster(json.getString("Poster"))
                .build();
    }

    // Transforms Movie objects to coma separated values
    public static String movieToCsv(Movie m) {
        return String.format("%s,%s,%s,%s,%s%n", m.getImdbId(), m.getTitle(), m.getYear(), m.getType(), m.getPoster());
    }
}
