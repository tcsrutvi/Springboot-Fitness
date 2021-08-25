package com.fitness.tracker.repository;
import org.springframework.data.repository.CrudRepository;

import com.fitness.tracker.Appointment;

public interface IAppointmentRepository extends CrudRepository<Appointment, Integer>{

}
