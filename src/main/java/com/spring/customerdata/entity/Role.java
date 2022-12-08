package com.spring.customerdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String role;
	
	@Column(name="delivery")
	private long deliveryCharge;
	
	public long getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(long deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
