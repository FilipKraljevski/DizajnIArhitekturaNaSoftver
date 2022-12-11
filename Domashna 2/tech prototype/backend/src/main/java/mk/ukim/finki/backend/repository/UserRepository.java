package mk.ukim.finki.backend.repository;

import mk.ukim.finki.backend.bootsrap.DataHolder;
import mk.ukim.finki.backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    public Optional<User> findByUsername(String username){
        return DataHolder.users.stream().
                filter(r -> r.getUsername().equals(username))
                .findFirst();
    }

    public Optional<User> findByEmail(String email){
        return DataHolder.users.stream().
                filter(r -> r.getEmail().equals(email))
                .findFirst();
    }

    public Optional<User> findByEmailAndPassword(String email, String password){
        return DataHolder.users.stream().
                filter(r -> r.getEmail().equals(email) && r.getPassword().equals(password))
                .findFirst();
    }

    public User save(User user){
        DataHolder.users.removeIf(r -> r.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        DataHolder.saveUser(user);
        return user;
    }
}
