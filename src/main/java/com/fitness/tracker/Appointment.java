package com.fitness.tracker;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srno;
	
	private String name;
	
	private Integer phone;
	
	private String email;
	
	private Integer age;
	
	private String address;
	
	private String trainer_preference;
	
	private String physio;
	
	private Integer pack;
	
	private Integer amount;

	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTrainer_preference() {
		return trainer_preference;
	}

	public void setTrainer_preference(String trainer_preference) {
		this.trainer_preference = trainer_preference;
	}

	public String getPhysio() {
		return physio;
	}

	public void setPhysio(String physio) {
		this.physio = physio;
	}

	public Integer getPack() {
		return pack;
	}

	public void setPack(Integer pack) {
		this.pack = pack;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
}
