package com.softtek.academia.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

	@Autowired
	MovieService movieService;
	
	@GetMapping (value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> getMovieList() {
		return movieService.getAllMovies();
	}

	@GetMapping (value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Movie getById(@PathVariable("id") Integer id) {
		return movieService.getMovieById(id);
	}
	
	 @GetMapping(value="/name/{title}",produces = MediaType.APPLICATION_JSON_VALUE)
	 private List<Movie> getMovieByName(@PathVariable String title) {
		 return movieService.findByName(title);
		 }
	 
	
	@PostMapping (value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public boolean addMovie(@RequestBody Movie requestBody) {	
		return movieService.saveMovie(requestBody);
	}
	
	@PutMapping (value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Movie udpateMovie(@PathVariable ("id") Integer id, @RequestBody Movie requestBody) {		
		return movieService.updateMovie(requestBody);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMovie (@PathVariable ("id") Integer id) {
		movieService.deleteMovieById(id);
	}
}
