package com.capgimini.project.dto;

public class GenreChartDTO {
    private String genre;
    private long count;

    // Constructor
    public GenreChartDTO(String genre, long count) {
        this.genre = genre;
        this.count = count;
    }

    // Getters and Setters
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public long getCount() { return count; }
    public void setCount(long count) { this.count = count; }
}

