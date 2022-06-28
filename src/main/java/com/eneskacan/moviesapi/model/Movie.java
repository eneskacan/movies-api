package com.eneskacan.moviesapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    private final String title;
    private final int year;
    private final String imdbId;
    private final String type;
    private final String poster;
}
