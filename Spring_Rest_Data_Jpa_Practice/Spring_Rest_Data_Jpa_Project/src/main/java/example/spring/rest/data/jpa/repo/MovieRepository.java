package example.spring.rest.data.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.rest.data.jpa.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
//no methods needed as long as just curd option are to performed
	// for additional functionality, methods can be declared 
}
