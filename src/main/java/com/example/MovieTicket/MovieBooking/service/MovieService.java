package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;

@Service
@Scope("singleton")
public class MovieService implements MovieServiceInterface {

	private ArrayList<Movie> movieList = new ArrayList<>();
    HashMap<String,Movie>movieMap = new HashMap<>();
	@Override
	public ArrayList<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("Id Not Found"+id);
		}
		return movieMap.get(id);
	}

	@Override
	public void deleteMovieById(String id) {
		// TODO Auto-generated method stub
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("Id Not Found"+id);
		}
		Movie movie = movieMap.get(id);
		movieMap.remove(id);
		movieList.remove(movie);
	}

	@Override
	public void updateMovieById(String id, Movie updateMovie) {
		// TODO Auto-generated method stub
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("Id Not Found"+id);
		}
		deleteMovieById(id);
		addMovie(updateMovie);	
	}

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		if(movieMap.containsKey(movie.getId())) {
			throw new IdAlreadyExist("Id Already Exist"+movie.getId());
		}
		if (movie != null) {
			movieList.add(movie);
			movieMap.put(movie.getId(), movie);
		}

	}

}
