package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;

import com.example.MovieTicket.MovieBooking.Model.Movie;

public interface MovieServiceInterface {
     public void addMovie(Movie movie); 
     public ArrayList<Movie>getAllMovies();
	Movie getMovieById(String id);
	void deleteMovieById(String id);
	void updateMovieById(String id, Movie updateMovie);
}
