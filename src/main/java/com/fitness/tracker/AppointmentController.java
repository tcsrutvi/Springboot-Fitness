package com.fitness.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppointmentController {

	@Autowired
	IAppointmentRep repos;
		
	@GetMapping("/viewapp")
	private String viewAppointment() {
		System.out.println("11");
		return "hello";
	}
	
	@PostMapping("/postapp")
	public void saveUser(@RequestBody Appointment appointment) {
		repos.save(appointment);
		System.out.println(appointment.getName());
	}
	

}
