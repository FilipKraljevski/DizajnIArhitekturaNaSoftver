package mk.ukim.finki.backend.web;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.backend.model.Exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.backend.model.User;
import mk.ukim.finki.backend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage(HttpServletRequest request){
        if(request.getSession().getAttribute("user") != null){
            return "home";
        }
        return "login";
    }
}
