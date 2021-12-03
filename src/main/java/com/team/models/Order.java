package com.team.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int userId;
	private int bookId;
	private double price;
	private String address;
	private Date datetime;
	
	@OneToMany( fetch =FetchType.EAGER,
			mappedBy = "order")
	public List<Book>bookList;



	public Order(int orderId, int userId, int bookId, double price, String address, Date datetime,
			List<Book> bookList) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.bookId = bookId;
		this.price = price;
		this.address = address;
		this.datetime = datetime;
		this.bookList = bookList;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}

	


