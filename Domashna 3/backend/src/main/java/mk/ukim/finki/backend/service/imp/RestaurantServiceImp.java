package mk.ukim.finki.backend.service.imp;

import mk.ukim.finki.backend.model.Exceptions.InvalidArgumentsException;
import mk.ukim.finki.backend.model.Exceptions.RestaurantAlreadyExistsException;
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
    public Restaurant findByName(String name) {
        return restaurantRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Restaurant> findBySuburb(String suburb) {
        return restaurantRepository.findBySuburb(suburb);
    }

    @Override
    public List<Restaurant> findByStreet(String street) {
        return restaurantRepository.findByStreet(street);
    }

    @Override
    public Restaurant saveRestaurant(String name, String suburb, String street, Double lat, Double lon, String opens,
                                     String closes, String website, String phone) {
        if(name == null || name.isEmpty() || suburb == null || suburb.isEmpty() || street == null || street.isEmpty() ||
                lat == null || lat.isInfinite() || lat.isNaN() || lon == null || lon.isNaN() || lon.isInfinite()){
            throw new InvalidArgumentsException();
        }
        if(restaurantRepository.findByName(name).isPresent()){
            throw new RestaurantAlreadyExistsException(name);
        }
        Restaurant restaurant = new Restaurant(name, suburb, street, lat, lon, opens, closes, website, phone);
        return restaurantRepository.saveRestaurant(restaurant);
    }
}
