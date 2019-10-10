package com.stackroute.Movie.service;

import org.junit.Test;
import com.stackroute.Movie.Exception.MovieAlreadyFoundException;
import com.stackroute.Movie.model.Movie;
import com.stackroute.Movie.repository.MovieMongoRepository;
import com.stackroute.Movie.service.MovieService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class MovieMongoServiceImplTest {

    Movie movie;

    //Create a mock for UserRepository
    @Mock
    MovieMongoRepository movieMongoRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    MovieMongoServiceImpl movieService;
    List<Movie> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        movie= new Movie();
        movie.setMovieGenre("action");
        movie.setMovieName("DarkNight");
        movie.setMovieBudget(new BigDecimal(1000));
        movie.setMovieReleaseDate("wednesday");
        movie.setMovieCast("batman");
        movie.setMovieId(67);
        list = new ArrayList();
        list.add(movie);


    }

    @Test
    public void saveUserTestSuccess() throws MovieAlreadyFoundException {

   /*     when(movieMongoRepository.save((Movie) any())).thenReturn(movie);
        Movie savedUser = movieService.saveMovie(movie);
        Assert.assertEquals(movie,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(movieMongoRepository,times(1)).save(movie);*/
    }

    @Test(expected = MovieAlreadyFoundException.class)
    public void saveUserTestFailure() throws MovieAlreadyFoundException {
        when(movieMongoRepository.save((Movie)any())).thenReturn(null);
        Movie savedUser = movieService.saveMovie(movie);
        System.out.println("savedUser" + savedUser);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        movieMongoRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieMongoRepository.findAll()).thenReturn(list);
        List<Movie> userlist = movieService.getallmovie();
        Assert.assertEquals(list,userlist);
    }

}