package com.example.demo.Service;

import com.example.demo.Module.Movie;
import com.example.demo.Repository.MovieRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class MovieService {

    private MovieRepository movieRepository = new MovieRepository();

    public Movie getFirst(){
        return movieRepository.getOne(0);
    }

    public Movie getRandom(){
        Random random = new Random();
        return movieRepository.getOne(random.nextInt(movieRepository.getMovies().size()));
    }

    public ArrayList<Movie> get10MostPopular(){

        ArrayList<Movie> random10Movies = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            random10Movies.add(getRandom());
        }
        Collections.sort(random10Movies);
        return random10Movies;

    }

    public int howManyWonAward(){

        int count = 0;

        for (Movie i: movieRepository.getMovies()) {
            if (i.getAwards().contains("Yes")){
                count++;
            }
        }

        return count;
    }

    public ArrayList<Movie> filter(String c, int num){

        ArrayList<Movie> filteredMovies = new ArrayList<>();
        int count = 0;
        char ch = c.charAt(0);

        for (Movie i: movieRepository.getMovies()) {
            if (i.getTitle().contains(c)|| i.getTitle().contains(c.toUpperCase(Locale.ROOT))){
                for (int j = 0; j < i.getTitle().length(); j++) {
                    if (i.getTitle().toLowerCase().charAt(j) == ch){
                        count++;
                    }
                }
            }
            if (count == num) {
                filteredMovies.add(i);
            }
            count = 0;
        }
        return filteredMovies;
    }


    public String longestGenre(String g1,String g2){

        ArrayList<Movie> genre1 = new ArrayList<>();
        ArrayList<Movie> genre2 = new ArrayList<>();

        for (Movie i: movieRepository.getMovies()) {
            if (i.getSubject().toLowerCase().contains(g1)){
                genre1.add(i);
            } else if (i.getSubject().toLowerCase().contains(g2)){
                genre2.add(i);
            }
        }
        if (calcAverage(genre1) > calcAverage(genre2)){
            return g1;
        } else {
            return g2;
        }

    }
    private int calcAverage(ArrayList<Movie> movies){
        int totalLength = 0;
        for (Movie i: movies) {
            totalLength += i.getLength();
        }
        return totalLength / movies.size();
    }
}

