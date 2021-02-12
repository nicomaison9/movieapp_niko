package movieapp.dto;

import movieapp.entity.Artist;
import movieapp.entity.Movie;

public class Playstatistics {
Artist actor;
Movie movie;
public Playstatistics(Artist actor, Movie movie) {
	super();
	this.actor = actor;
	this.movie = movie;
}
public Artist getActor() {
	return actor;
}
public void setActor(Artist actor) {
	this.actor = actor;
}
public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}

}
