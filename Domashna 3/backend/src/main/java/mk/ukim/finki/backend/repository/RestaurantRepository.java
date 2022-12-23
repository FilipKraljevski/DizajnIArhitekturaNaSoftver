package mk.ukim.finki.backend.repository;

import mk.ukim.finki.backend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAllByName(String name);
    List<Restaurant> findAllBySuburb(String suburb);
    List<Restaurant> findAllByStreet(String street);
}
