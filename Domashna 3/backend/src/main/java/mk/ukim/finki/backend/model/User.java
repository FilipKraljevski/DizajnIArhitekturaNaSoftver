package mk.ukim.finki.backend.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.id = (long) (Math.random() * 1000);
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
