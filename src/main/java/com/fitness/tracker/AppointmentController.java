package com.fitness.tracker;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;

import com.fitness.tracker.exceptions.UserIdNotFoundException;
import com.fitness.tracker.exceptions.UserNameNotFoundException;

@RestController
@RequestMapping("/app")
public class AppointmentController {

	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	@Autowired
	IAppointmentRepository repo;

	@Autowired
	AppointmentService appointmentService;

	@GetMapping("/appointment")
	private Iterable<Appointment> getAppointment() {
		return appointmentService.getAllUsers();
	}

	@GetMapping("/appointment/{id}")
	private Optional<Appointment> getAppointment(@PathVariable("id") Integer id) {
		return appointmentService.getUser(id);
	}

	@PostMapping("/appointment")
	private void saveAppointment(@RequestBody Appointment appointment) {

		appointmentService.save(appointment);
		System.out.println(appointment.getName());
	}

	@DeleteMapping("/appointment/{id}")
	private void deleteAppointment(@PathVariable("id") Integer id) {
		appointmentService.delete(id);
	}

	@PutMapping("/appointment/{id}")
	public void updateAppointment(@PathVariable("id") Integer id, @RequestBody Appointment app) {
		Appointment appFromDb = repo.findById(id).get();
		if (StringUtils.hasText(app.getTrainer_preference())) {
			appFromDb.setTrainer_preference(app.getTrainer_preference());
		}
		if (StringUtils.hasText(app.getPack())) {
			appFromDb.setPack(app.getPack());
		}
		if (app.getAmount() != 0) {
			appFromDb.setAmount(app.getAmount());
		}
		repo.save(appFromDb);
	}

	@ExceptionHandler(value = { UserIdNotFoundException.class })
	public ResponseEntity<Appointment> exception2(UserIdNotFoundException idNotFound) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { UserNameNotFoundException.class, IllegalStateException.class,
			EmptyResultDataAccessException.class })
	public ResponseEntity<Appointment> exception(RuntimeException runtimeException) {
		return new ResponseEntity<Appointment>(HttpStatus.BAD_REQUEST);
	}

}
