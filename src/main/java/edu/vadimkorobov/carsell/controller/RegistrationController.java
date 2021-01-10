package edu.vadimkorobov.carsell.controller;

import edu.vadimkorobov.carsell.entity.User;
import edu.vadimkorobov.carsell.entity.dto.UserDto;
import edu.vadimkorobov.carsell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }
    @GetMapping
    public String registration(HttpServletRequest request) {
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDto userDto,
                                      BindingResult result) {

        User existingByLogin = userService.getByLogin(userDto.getLogin());
        if (existingByLogin != null) {
            result.rejectValue("login", null, "There is already an account registered with that login");
        }


        if (result.hasErrors()) {
            return "registration";
        }
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        userService.addAccount(user);
        return "redirect:/login?success";
    }

}