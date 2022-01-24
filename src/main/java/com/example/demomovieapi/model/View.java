package com.example.demomovieapi.model;

public interface View {
    interface TvList {}
    interface TvDetail extends TvList {}
    interface MovieList {}
    interface MovieDetail extends MovieList {}
}
