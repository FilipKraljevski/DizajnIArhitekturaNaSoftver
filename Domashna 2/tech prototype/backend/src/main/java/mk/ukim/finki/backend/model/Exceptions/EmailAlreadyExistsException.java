package mk.ukim.finki.backend.model.Exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String email) {
        super(String.format("User with username %s already exists", email));
    }
}
