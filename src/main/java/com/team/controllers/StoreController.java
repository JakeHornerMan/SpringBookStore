package com.team.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.models.Book;
import com.team.services.BookService;
import com.team.services.OrderService;

@Controller
public class StoreController {
	
	@Autowired
	BookService bookservice;
	
	
	@Autowired
	OrderService orderSErvice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLanding() {
		
		ModelAndView mav = new ModelAndView();
		List<Book> books = bookservice.getAllBooks();
		
		mav.addObject("listBooks", books);
    	mav.setViewName("/index");
		return mav;
    }
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView getAttendees(@RequestParam("bookId") int bookId, Model model) {
		
		Book book = bookservice.getOne(bookId);
		model.addAttribute("book",book);
		
		ModelAndView mav = new ModelAndView();
    	
    	mav.setViewName("book");
    	mav.addObject("book", book);
    	
		return mav;	
	}
	
	
	@PostMapping(value = "/addtocart")
	public String addToCart(@RequestParam("bookId") int bookId, Model model) {
		
		orderSErvice.addToCart(bookId);
		return "add_success";
	   
	} 
	
	
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView viewCart() {
		
		ModelAndView mav = new ModelAndView();
		List<Book> books = bookservice.getCartBooks();
		
		mav.addObject("cartBooks", books);
    	mav.setViewName("/cart");
		return mav;
    }
	
}
