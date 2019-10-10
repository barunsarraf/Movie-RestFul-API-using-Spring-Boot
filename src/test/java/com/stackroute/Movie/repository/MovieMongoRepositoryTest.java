package com.stackroute.Movie.repository;

import com.stackroute.Movie.model.Movie;
import com.stackroute.Movie.repository.MovieMongoRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MovieMongoRepositoryTest {
    @Autowired
    MovieMongoRepository movieMongoRepository;
    Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie();
        movie= new Movie();
        movie.setMovieGenre("action");
        movie.setMovieName("DarkNight");
        movie.setMovieBudget(new BigDecimal(1000));
        movie.setMovieReleaseDate("wednesday");
        movie.setMovieCast("batman");
        movie.setMovieId(99);

    }

    @After
    public void tearDown(){

        movieMongoRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        movieMongoRepository.save(movie);
        Movie fetchUser = movieMongoRepository.findById(movie.getMovieId()).get();
        Assert.assertEquals(99,fetchUser.getMovieId());

    }

    @Test
    public void testSaveUserFailure(){
        Movie m = new Movie();
        m.setMovieGenre("action");
        m.setMovieName("SunNight");
        m.setMovieBudget(new BigDecimal(1000));
        m.setMovieReleaseDate("wednesday");
        m.setMovieCast("batman");
        m.setMovieId(98);
        movieMongoRepository.save(m);
        Movie fetchUser = movieMongoRepository.findById(m.getMovieId()).get();
        Assert.assertNotSame(m,movie);
    }

    @Test
    public void testGetAllUser(){
        Movie m1 = new Movie();
        Movie m2 = new Movie();

        m1.setMovieGenre("horror");
        m1.setMovieName("DarkSun");
        m1.setMovieBudget(new BigDecimal(1000));
        m1.setMovieReleaseDate("wednesday");
        m1.setMovieCast("batman");
        m1.setMovieId(123);

        m2.setMovieGenre("suspense");
        m2.setMovieName("DarkSun");
        m2.setMovieBudget(new BigDecimal(1000));
        m2.setMovieReleaseDate("wednesday");
        m2.setMovieCast("batman");
        m2.setMovieId(122);


        movieMongoRepository.save(m1);
        movieMongoRepository.save(m2);

        List<Movie> list = movieMongoRepository.findAll();
        Assert.assertEquals(123,list.get(0).getMovieId());

    }

}
