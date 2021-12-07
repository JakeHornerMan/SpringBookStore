package com.team.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.team.models.Order;
import com.team.repos.OrderRepo;

@Service
@Configurable
public class OrderService {
	
	@Autowired
	private OrderRepo repo;
	
	List<Order> cart = new ArrayList<Order>();
	
	List<Integer> cartWithBookIds = new ArrayList<>();
	
	public void addToCart(Order o) {
		cart.add(o);
	}
	
	
	
	public boolean addToCart(int bookId) {
		return cartWithBookIds.add(bookId);
	}
	
	public List<Order> getCart() {
		return cart;
	}
	
	public void deleteCartItem(Order o) {
		cart.remove(o);
	}
	
	public void clearCart() {
		cart.clear();
	}
	
	public List<Order> getAll(){
		return repo.findAll();
	}
	
	public void saveOne(Order o) {
		repo.save(o);
	}
	
	public Order getOne(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteOne(int id) {
		repo.deleteById(id);
	}
	
	public List<Integer> getBookIdsFromCart(){
		return cartWithBookIds;
	}
	 

}
