package com.softtek.academia.service;

import java.util.List;


import com.softtek.academia.entity.Movie;

public interface MovieService {
	
	public List<Movie> getAllMovies();
	public Movie getMovieById(Integer id);
	public boolean saveMovie(Movie Movie);
	public boolean deleteMovieById(Integer id);
	public Movie updateMovie(Movie Movie);
	public List<Movie>findByName(String title);
}
