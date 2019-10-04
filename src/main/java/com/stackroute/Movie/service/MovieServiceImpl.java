package com.stackroute.Movie.service;

import com.stackroute.Movie.Exception.MovieNotFoundException;
import com.stackroute.Movie.model.Movie;
import com.stackroute.Movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
@Profile("prod")
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie saveMovie(Movie movie) throws MovieNotFoundException {

        System.out.println("this is save method in primary movie service impl");
        if(movieRepository.existsById(movie.getMovieId()))
        {
            throw new MovieNotFoundException("Movie already present with this id");
        }
        else
        {
            Movie savedmovie =movieRepository.save(movie);
            return savedmovie;
        }


    }

    @Override
    public List<Movie> getallmovie() {
        return movieRepository.findAll();
    }

/*    @Override
    public Movie updateMovie(int movieId,String movieCast) {
        Movie updatemovie=movieRepository.findById(movieId).get();
        updatemovie.setMovieCast(movieCast);
        movieRepository.save(updatemovie);
        return updatemovie;
    }*/

    @Override
    public Movie updateMovieusingput(Movie movie) throws MovieNotFoundException {
        if(movieRepository.existsById(movie.getMovieId()))
        {
            movieRepository.save(movie);
            return movie;
        }
        else
        {
            throw new MovieNotFoundException("Movie is not present with this id");
        }

    }

    @Override
    public Movie getmoviebyid(int movieId) {
        Movie moviebyid=movieRepository.findById(movieId).get();
        return moviebyid;
    }

    @Override
    public Movie deletemoviebyid(int movieId) {
        Movie movie_to_be_deleted = movieRepository.findById(movieId).get();
        movieRepository.delete(movie_to_be_deleted);
        return movie_to_be_deleted;
    }


    @Override
    public Movie getmoviebyname(String movieName) {

        Movie moviebyname= movieRepository.findmovie(movieName);
        System.out.println("got movie this"+moviebyname);
        return moviebyname;
    }

}
