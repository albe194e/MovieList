package com.example.demo.Module;

public class Movie implements Comparable<Movie>{

    private String title;
    private String year;
    private int length;
    private String subject;
    private String popularity;
    private String awards;


    public Movie(String year, int length, String title,String subject,String popularity,String awards){
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;

    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int compareTo(Movie o) {
        return o.popularity.compareTo(this.popularity);
    }

    @Override
    public String toString() {
        return "\nTitle: " + title +
                "\nYear: " + year +
                "\nLength: " + length +
                "\nSubject: " +subject +
                "\nPopularity: " + popularity +
                "\nAwards: " + awards;

    }
}