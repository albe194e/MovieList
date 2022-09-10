package com.example.demo.Repository;

import com.example.demo.Module.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRepository {

    public List<Movie> getMovies() {
        return movies;
    }

    private List<Movie> movies;

    public MovieRepository()  {
        this.movies = new ArrayList<>();
        generateMovieList();
    }

    private void generateMovieList()  {

        try {
            Scanner input = new Scanner(new File("C:\\Users\\DHI-LAP\\IdeaProjects\\demo2\\src\\main\\resources\\Movies\\Movies.csv"));
            input.useDelimiter(";|\n");

            input.nextLine();
            while (input.hasNext()){
                String year = input.next();
                int length = Integer.parseInt(input.next());
                String title = input.next();
                String subject = input.next();
                String popularity = input.next();
                String awards = input.next();

                addMovieToList(new Movie(year,length,title,subject,popularity,awards));
            }

        } catch (FileNotFoundException e){
            throw new RuntimeException();
        }
    }


    private void addMovieToList(Movie movie){
        movies.add(movie);
    }

    public Movie getOne(int index){
        return movies.get(index);
    }

}
