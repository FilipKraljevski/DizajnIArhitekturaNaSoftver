package mk.ukim.finki.backend.service.imp;

import mk.ukim.finki.backend.model.Exceptions.EmailAlreadyExistsException;
import mk.ukim.finki.backend.model.Exceptions.InvalidArgumentsException;
import mk.ukim.finki.backend.model.Exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.backend.model.User;
import mk.ukim.finki.backend.repository.UserRepository;
import mk.ukim.finki.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String email, String password) {
        if(email == null || email.isEmpty() || password == null ||password.isEmpty()){
            throw new InvalidArgumentsException();
        }
        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String email, String password) {
        if(username == null || username.isEmpty() || password == null ||password.isEmpty() || email == null || email.isEmpty()){
            throw new InvalidArgumentsException();
        }
        if(userRepository.findByEmail(email).isPresent() || !userRepository.findByEmail(email).isEmpty()){
            throw new EmailAlreadyExistsException(username);
        }
        User user = new User(username, email, password);
        return userRepository.save(user);
    }
}
