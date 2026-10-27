package com.devsuperior.dsmovie.tests;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;

public class MovieFactory {
	
	public static Movie createMovieEntity() {
		Movie movie = new Movie(1L, "Test Movie", 0.0, 0, "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg");
		return movie;
	}
	
	public static MovieDTO createMovieDTO() {
		Movie movie = createMovieEntity();
		return new MovieDTO(movie);
	}
}
