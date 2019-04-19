package com.example.immutable;

import java.util.ArrayList;
import java.util.List;

public class ImmutablePerson {

    private final String name;
    private final String city;
    private final List<String> favoriteDishes;

    private ImmutablePerson(Builder builder) {
        name = builder.name;
        city = builder.city;
        favoriteDishes = builder.favoriteDishes;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<String> getFavoriteDishes() {
        return favoriteDishes != null ? new ArrayList<>() : null;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String name;
        private String city;
        private List<String> favoriteDishes;

        public Builder() {
            // Empty constructor
        }

        public Builder(ImmutablePerson person) {
            name = person.name;
            city = person.city;
            favoriteDishes = person.favoriteDishes != null ? new ArrayList<>(person.favoriteDishes) : null;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withFavoriteDishes(List<String> dishes) {
            favoriteDishes = dishes != null ? new ArrayList<>(dishes) : null;
            return this;
        }

        public ImmutablePerson build() {
            return new ImmutablePerson(this);
        }
    }
}
