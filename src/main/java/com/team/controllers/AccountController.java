package com.team.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.models.User;
import com.team.services.OrderService;
import com.team.services.UserService;

@Controller
public class AccountController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
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
    public ModelAndView saveUser(User user, @ModelAttribute("userEmail") String email,
                           @ModelAttribute("userPassword") String password,
                           Model model) {

        model.addAttribute("userEmail", email);
        model.addAttribute("userPassword", password);
        service.encryptAndSave(user);
        return new ModelAndView("index");
    }
}
