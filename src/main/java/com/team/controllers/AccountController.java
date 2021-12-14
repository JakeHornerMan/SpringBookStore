package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.models.OnRegistrationCompleteEvent;
import com.team.models.User;
import com.team.services.OrderService;
import com.team.services.UserService;

@Controller
public class AccountController {
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
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
    public String saveUser(User user, @ModelAttribute("userEmail") String email,
                           @ModelAttribute("userPassword") String password,
                           Model model) {

        model.addAttribute("userEmail", email);
        model.addAttribute("userPassword", password);
        service.encryptAndSave(user);
        return "login";
    }
	
//	@PostMapping("/user/registration")
//	public ModelAndView registerUserAccount(User user, @ModelAttribute("userEmail") String email,
//              @ModelAttribute("userPassword") String password,
//              Model model,  HttpServletRequest request) { 
//	    
//	    try {
//	        User registered = service.encryptAndSave(user);
//	        
//	        String appUrl = request.getContextPath();
//	        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, 
//	          request.getLocale(), appUrl));
//	    } catch (UserAlreadyExistException uaeEx) {
//	        ModelAndView mav = new ModelAndView("registration", "user", userDto);
//	        mav.addObject("message", "An account for that username/email already exists.");
//	        return mav;
//	    } catch (RuntimeException ex) {
//	        return new ModelAndView("emailError", "user", userDto);
//	    }
//
//	    return new ModelAndView("successRegister", "user", userDto);
//	}
//	
}
