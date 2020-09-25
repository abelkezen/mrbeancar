package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

	
	@Id
    @GeneratedValue
    @Column(name = "serialid", nullable = false)
	private Long serialid;
	
	@Column(name = "company", length = 255, nullable = false)
    private String company;
	
	@Column(name = "dop", nullable = false)
	private Long dop;
	
	@Column(name = "price", nullable = false)
	private Long price;
	
	@Column(name = "seats", nullable = false)
	private Long seats;
	
	@Column(name = "regno", length = 255, nullable = false)
    private String regno;
	
	@Column(name = "model", length = 255, nullable = false)
    private String model;
	
	@Column(name = "color", length = 255, nullable = false)
    private String color;
	
	@Column(name = "engine", length = 255, nullable = false)
    private String engine;
	
	@Column(name = "uid", length = 255, nullable = false)
    private String uid;
	
	public Long getSerialid() {
		return serialid;
	}

	public void setSerialid(Long serialid) {
		this.serialid = serialid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getDop() {
		return dop;
	}

	public void setDop(Long dop) {
		this.dop = dop;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getSeats() {
		return seats;
	}

	public void setSeats(Long seats) {
		this.seats = seats;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	
}
