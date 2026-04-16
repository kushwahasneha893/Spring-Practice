package example.spring.rest.data.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import example.spring.rest.data.jpa.entity.Movie;
import example.spring.rest.data.jpa.repo.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepo;
	public List<Movie> getALL() {
		List<Movie> allMovies = movieRepo.findAll();
		return allMovies;
	}
	public Movie getById(Integer movieId) {
//		Movie foundMovie = null;
//		/*Optional<Movie> opRef = movieRepo.findById(movieId);
//		if (opRef.isPresent())
//			foundMovie = opRef.get();*/
//		Optional<Movie> opRef = movieRepo.findById(movieId);
//		foundMovie = opRef.orElse(null);
		return movieRepo.findById(movieId).orElse(null);
	}
	public void create(Movie movieObj) {
		movieRepo.save(movieObj);
	}
	public void update(Integer movieId, Movie movieObj) {
		Movie foundMovie = movieRepo.save(movieObj);
		if(foundMovie!=null)
			foundMovie.setTitle(movieObj.getTitle());
			foundMovie.setGenre(movieObj.getGenre());
			foundMovie.setYear(movieObj.getYear());
			movieRepo.save(foundMovie);
	}
	public void deleteById(Integer movieId) {
		movieRepo.deleteById(movieId);
	}
}


