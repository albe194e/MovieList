package com.example.demo.Controller;

import com.example.demo.Module.Movie;
import com.example.demo.Service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieController {

    private MovieService movieService = new MovieService();

    @GetMapping("/getfirst")
    public Movie getFirst(){
        return movieService.getFirst();
    }
    @GetMapping("/getrandom")
    public Movie getRandom(){
        return movieService.getRandom();
    }
    @GetMapping("/gettop10")
    public String getTop10(){
        return movieService.get10MostPopular().toString();
    }
    @GetMapping("/howmanywonaward")
    public String howManyWonAward(){
        return "Movies that won an award: " + movieService.howManyWonAward();
    }
    @GetMapping("/filter")
    public ArrayList<Movie> filter(@RequestParam String c, @RequestParam int num){
        return movieService.filter(c,num);
    }
    @GetMapping("/longest")
    public String longestGenre(@RequestParam String g1, @RequestParam String g2){
        return "The genre that on average has the longest movies is: " + movieService.longestGenre(g1,g2);
    }
}