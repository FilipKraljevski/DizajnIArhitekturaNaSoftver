package mk.ukim.finki.backend.service;

import mk.ukim.finki.backend.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();

    Restaurant findByName(String name);

    List<Restaurant> findBySuburb(String suburb);

    List<Restaurant> findByStreet(String street);

    Restaurant saveRestaurant(String name, String suburb, String street, Double lat, Double lon, String opens, String closes,
                              String website, String phone);
}
