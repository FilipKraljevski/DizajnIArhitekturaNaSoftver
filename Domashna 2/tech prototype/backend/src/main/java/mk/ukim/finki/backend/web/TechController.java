package mk.ukim.finki.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TechController {
    @GetMapping
    public String hello(){
        return "home";
    }
}
