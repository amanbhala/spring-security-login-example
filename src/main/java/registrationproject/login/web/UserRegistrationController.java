package registrationproject.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import registrationproject.login.service.UserService;
import registrationproject.login.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    // Either we can create this method to store user submitted form data in the UserRegistrationDto object or 
    // directly pass model object in the showRegistrationForm method and add form data to the model object.
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        // model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        // Form that user submitted is stored into "user" object and we bind this form data into UserRegistrationDto object.
        // We then save user data in the database
        userService.save(registrationDto);
        // We then redirect to the registration page
        return "redirect:/registration?success";
    }
    
}
