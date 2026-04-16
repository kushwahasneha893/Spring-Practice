package example.spring.rest.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.data.jpa.entity.Movie;
import example.spring.rest.data.jpa.exception.MovieNotFoundException;
import example.spring.rest.data.jpa.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieRestController {
	@Autowired
	private MovieService movieServ;
	@GetMapping
	public List<Movie> getAll() {
		return movieServ.getALL();
	}
	//@GetMapping("/{movieId}")
	public Movie getById(@PathVariable Integer movieId) {
		//return movieServ.getById(movieId);
		Movie foundMovie = movieServ.getById(movieId);
		if(foundMovie == null)
			throw new  MovieNotFoundException("Movie not found with ID : " + movieId);
		return foundMovie;
	}
	@GetMapping("/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) {
		//ResponseEntity.notFound().build();
		//return movieServ.getById(movieId);
		Movie foundMovie = movieServ.getById(movieId);
		ResponseEntity<Movie> responseEntityRef = ResponseEntity.notFound().build();
		if(foundMovie != null)
			responseEntityRef  = ResponseEntity.ok(foundMovie);
		return responseEntityRef;
	}
	@PostMapping 
	public void create(@RequestBody Movie movieObj) {
		movieServ.create(movieObj);
	}
	@PutMapping("/{movieId}")
	public void update(@PathVariable Integer movieId, @RequestBody Movie movieObj) {
		movieServ.update(movieId, movieObj);
	}
	@DeleteMapping("/{movieId}")
	public void deleteById(@PathVariable Integer movieId) {
		movieServ.deleteById(movieId);
	}
}
