package movieapp.persistence.hibernate;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import movieapp.entity.Movie;
import movieapp.persistence.MovieRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestJoinFetchLazyEager {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	EntityManager entityManager;
	

	@Test
	void testReadMovieWithAssociatedObjects2() {
		var movie = movieRepository.findByTitle("The Terminator").get(0);
		System.out.println(movie);
		
	}
	@Test
	void test_moviesWithDirector() {
		var movies = movieRepository.findByTitleContainingIgnoreCase("terminator");
		for (var movie:movies)
		{
			System.out.println(movie + "directed by: "+ movie.getDirector());
		}
		
	}
	
	@Test
	void test_moviesWithDirector_tuning() {
		String title= "terminator";
		var movies=entityManager.createQuery("select m from Movie m where lower(title) like %?1%",Movie.class)
		.setParameter(1, title)
		.getResultList();
		for (var movie:movies)
		{
			System.out.println(movie + "directed by: "+ movie.getDirector());
		}
		
	}

}
