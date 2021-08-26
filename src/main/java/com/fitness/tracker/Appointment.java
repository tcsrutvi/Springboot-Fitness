package com.fitness.tracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srno;

	@NotBlank
	@Size(min=4, max=20)
	private String name;

	@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}")
	private Integer phone;

	@Email
	private String email;

	@Min(18)
	private Integer age;
	
	@NotBlank
	private String address;
	
	@NotNull
	private String trainer_preference;

	@NotNull
	private String physio;

	@NotNull
	@Min(300)
	private String pack;

	@NotBlank
	@Size(min=3)
	private Integer amount;

}
