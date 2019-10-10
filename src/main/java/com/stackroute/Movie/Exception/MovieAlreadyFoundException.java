package com.stackroute.Movie.Exception;

public class MovieAlreadyFoundException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    public MovieAlreadyFoundException()
    {

    }

    public MovieAlreadyFoundException(String message1) {
        super(message1);
        this.message = message1;
    }
}
