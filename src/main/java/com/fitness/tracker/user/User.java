package com.fitness.tracker.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fitness.tracker.Appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String name;
	private int age;
	private String address;
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="User_Id")
	private Set<Appointment> appointments;
}
