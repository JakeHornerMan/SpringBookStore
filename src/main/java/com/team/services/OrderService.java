package com.team.services;

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
	 

}
