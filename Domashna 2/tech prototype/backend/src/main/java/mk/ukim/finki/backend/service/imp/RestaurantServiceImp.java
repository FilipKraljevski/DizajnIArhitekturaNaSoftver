package mk.ukim.finki.backend.service.imp;

import mk.ukim.finki.backend.model.Restaurant;
import mk.ukim.finki.backend.repository.RestaurantRepository;
import mk.ukim.finki.backend.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImp implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImp(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public List<Restaurant> findBySuburb(String suburb) {
        return restaurantRepository.findBySuburb(suburb);
    }

    @Override
    public List<Restaurant> findByStreet(String street) {
        return restaurantRepository.findByStreet(street);
    }
}
