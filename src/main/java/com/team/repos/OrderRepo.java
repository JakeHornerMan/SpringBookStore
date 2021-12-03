package com.team.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.models.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
