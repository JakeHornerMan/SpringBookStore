package com.team.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team.services.UserService;
import com.team.models.User;

@Controller
public class HomeController {
	
	private UserService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLanding() {
        return new ModelAndView("index");
    }
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
	
	@RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public String saveUser(User user, @ModelAttribute("userEmail") String username,
                           @ModelAttribute("userPassword") String email,
                           Model model) {

        //SPRING SECURITY PASSWORD ENCODER
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);


        model.addAttribute("userEmail", username);
        model.addAttribute("userPassword", email);
        service.save(user);
        return "<h1>DONE!</h1>";
    }
}
