package com.softtek.academia.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return (List<Movie>)repository.findAll();
	}

	@Override
	public Movie getMovieById(Integer id) {
		// TODO Auto-generated method stub
		Movie movie = repository.findById(id).get();
		return movie;
	}
	
	
	@Override
	public boolean saveMovie(Movie Movie) {
		// TODO Auto-generated method stub
		try {
			repository.save(Movie);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

//	public Movie add(final Movie movie) throws MovieAlreadyExistException  {		
//		Movie existingMovie = this.getOne(movie.getUsername());
//		if(existingUser == null){
//			return this.movieRepository.save(movie);
//		}else {
//			throw new MovieAlreadyExistException(new ErrorResponse(1000,"Movie " + user.getMoviename() + " already Exists"));
//		}
//	}
	
	@Override
	public boolean deleteMovieById(Integer id) {
		// TODO Auto-generated method stub
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
			return repository.save(movie); 
	}

	@Override
	public List<Movie> findByName(String title) {
		// TODO Auto-generated method stub
		List<Movie> pelicula=repository.findByTitle(title);
	  return pelicula;
	}
	
	
}
