package com.example.mutable;

import java.util.List;

public class MutablePerson {

    private String name;
    private String city;
    private List favoriteDishes;

    public MutablePerson(String name, String city, List favoriteDishes) {
        this.name = name;
        this.city = city;
        this.favoriteDishes = favoriteDishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List getFavoriteDishes() {
        return favoriteDishes;
    }

    public void setFavoriteDishes(List favoriteDishes) {
        this.favoriteDishes = favoriteDishes;
    }
}