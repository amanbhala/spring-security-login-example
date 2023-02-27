package registrationproject.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    // To print the authentication object in the SecurityContextHolder
    @GetMapping("/hello")
    public void hello(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Inside");
        System.out.println("Authentication object: " + authentication);
        // add authentication object to the model
        model.addAttribute("authentication", authentication);
        return ;
    }
}
