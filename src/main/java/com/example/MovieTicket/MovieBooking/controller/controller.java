package com.example.MovieTicket.MovieBooking.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;

import jakarta.validation.Valid;

@RestController
public class controller {
	
	@Autowired
    MovieService movieService;
	
	@GetMapping("/ticket/movies")
	public ArrayList<Movie> getAllMovie() {
       return  (ArrayList<Movie>) movieService.getAllMovies();   
	}

	@PostMapping("/ticket/movie")
	public void saveMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new RuntimeException();
		}
          movieService.addMovie(movie); 
	}

	@GetMapping("/ticket/movie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		return movieService.getMovieById(id);
	}

	@DeleteMapping("/ticket/movie/{id}")
	public void deleteMovieById(@PathVariable String id) {
             movieService.deleteMovieById(id);
	}

	@PutMapping("/ticket/update/{id}")
	public void updateMovieData(@PathVariable String id, @RequestBody Movie updatedMovie) {
        movieService.updateMovieById(id, updatedMovie);
    }
}
