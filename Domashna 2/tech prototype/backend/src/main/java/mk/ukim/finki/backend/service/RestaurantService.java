package mk.ukim.finki.backend.service;

import mk.ukim.finki.backend.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();

    List<Restaurant> findByName(String name);

    List<Restaurant> findBySuburb(String suburb);

    List<Restaurant> findByStreet(String street);
}
