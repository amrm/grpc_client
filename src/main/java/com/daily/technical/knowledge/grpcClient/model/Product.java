package com.daily.technical.knowledge.grpcClient.model;

import java.util.Date;


/**
 * 
 * 
 * @author Amr Abdeldayem
 *
 */
public class Product {

	Integer id;
	String name;
	String category;
	Double cost;
	Double price;
	Date expire;
	int count;
	String description;

	public Product() {

	}

	public Product(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(Integer id, String name, String category, Date expire, String description, Double price, Double cost,
			int count) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.cost = cost;
		this.count = count;
		this.description = description;
		this.expire = expire;
	}

	public Product(Integer id, String name, String category, Double price, Double cost) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
