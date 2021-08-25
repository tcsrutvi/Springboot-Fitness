package com.fitness.tracker.service;

import java.util.Optional;

import com.fitness.tracker.Appointment;

public interface IAppointmentService {

		void save(Appointment appointment);
		Iterable<Appointment> getAllUsers();
		Optional<Appointment> getUser(Integer id);
		void delete(Integer id);
		void update(Appointment appointment, Integer id);
	}

