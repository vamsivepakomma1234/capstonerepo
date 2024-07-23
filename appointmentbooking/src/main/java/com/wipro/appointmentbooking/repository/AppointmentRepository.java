package com.wipro.appointmentbooking.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.appointmentbooking.entity.Appointment;
import com.wipro.appointmentbooking.service.AppointmentService;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	//Appointment findAppointmentsByAid(Long appId);


	Appointment save(AppointmentService appointment);

	//Appointment findByAid(Long id);

}


