package com.fitness.tracker;

import java.util.Optional;

public interface IAppointmentService {

		void save(Appointment appointment);
		Iterable<Appointment> getAllUsers();
		Optional<Appointment> getUser(Integer id);
		void delete(Integer id);
		void update(Appointment appointment, Integer id);
	}

