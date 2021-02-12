package movieapp.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import movieapp.entity.Movie;

@DataJpaTest
class TestMovieCollections {

	@Autowired
	MovieRepository movieRepository;

	@Test
	void test() {
		Movie movieK = new Movie("Kingsman: the secret...",2014,129);
		movieK.setGenres(List.of("Action","Adventures","Comedy"));
		movieRepository.save(movieK);
		Movie movieX = new Movie("xXx",2002,124);
		movieX.setGenres(List.of("Action","Adventures","Thriller"));
		movieRepository.save(movieX);
		movieRepository.flush();
	}

}
