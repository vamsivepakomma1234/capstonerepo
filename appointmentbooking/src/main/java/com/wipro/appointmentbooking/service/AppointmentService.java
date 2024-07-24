package com.wipro.appointmentbooking.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.appointmentbooking.entity.Appointment;

import com.wipro.appointmentbooking.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public List<Appointment> getAppointments() {
		return appointmentRepository.findAll();
	}

	public void deleteAppointment(Long id) {
		appointmentRepository.deleteById(id);
	}

	public Appointment updateAppointment(Long id, Appointment appointment) {

		Optional<Appointment> apmt = appointmentRepository.findById(id);
		if (apmt.isPresent()) {
			Appointment existingAppointment = apmt.get();
			existingAppointment.setApmtDate(appointment.getApmtDate());
			existingAppointment.setApmtTime(appointment.getApmtTime());
			existingAppointment.setDoctorName(appointment.getDoctorName());
			existingAppointment.setPatient(appointment.getPatient());
			return appointmentRepository.save(existingAppointment);

		} else {
			throw new RuntimeException("appointment  " + id + " not found");
		}
	}

}
