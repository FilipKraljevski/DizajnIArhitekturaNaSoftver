package mk.ukim.finki.backend.model.Exceptions;

public class RestaurantAlreadyExistsException extends RuntimeException{
    public RestaurantAlreadyExistsException(String name) {
        super(String.format("Restaurant with name %s already exists", name));
    }
}
