package com.stackroute.Movie.service;

import com.stackroute.Movie.Exception.MovieAlreadyFoundException;
import com.stackroute.Movie.model.Movie;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyFoundException;
    public List<Movie> getallmovie();
   /* public Movie updateMovie(int movieId,String movieCast);*/
    public Movie updateMovieusingput(Movie movie) throws MovieAlreadyFoundException;
    public Movie getmoviebyid(int movieId);
    public Movie deletemoviebyid(int movieId);
    public Movie getmoviebyname(String movieName);
}
