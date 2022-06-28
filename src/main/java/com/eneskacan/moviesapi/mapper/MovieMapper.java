package com.eneskacan.moviesapi.mapper;

import com.eneskacan.moviesapi.model.Movie;

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

    // Transforms Movie objects to coma separated values
    public static String movieToCsv(Movie m) {
        return String.format("%s,%s,%s,%s,%s", m.getImdbId(), m.getTitle(), m.getYear(), m.getType(), m.getPoster());
    }
}
