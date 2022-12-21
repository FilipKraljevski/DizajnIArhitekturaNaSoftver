package mk.ukim.finki.backend.repository;

import mk.ukim.finki.backend.bootsrap.DataHolder;
import mk.ukim.finki.backend.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RestaurantRepository {
    public List<Restaurant> findAll(){
        return DataHolder.restaurants;
    }

    public Optional<Restaurant> findByName(String name){
        return DataHolder.restaurants.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();
    }

    public List<Restaurant> findBySuburb(String suburb){
        return DataHolder.restaurants.stream()
                .filter(r -> r.getName().equals(suburb))
                .collect(Collectors.toList());
    }

    public List<Restaurant> findByStreet(String street){
        return DataHolder.restaurants.stream()
                .filter(r -> r.getName().equals(street))
                .collect(Collectors.toList());
    }

    public Restaurant saveRestaurant(Restaurant restaurant){
        DataHolder.restaurants.add(restaurant);
        DataHolder.saveRestaurant(restaurant);
        return restaurant;
    }
}
