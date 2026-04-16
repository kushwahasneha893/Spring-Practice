package example.spring.rest.data.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
	public  MovieNotFoundException (String errorMessage) {
		super(errorMessage);
	}

}
