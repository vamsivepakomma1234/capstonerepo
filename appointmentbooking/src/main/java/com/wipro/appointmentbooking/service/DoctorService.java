package com.wipro.appointmentbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.appointmentbooking.dto.Doctor;

@Service
public class DoctorService {
	
	@Autowired
	DoctorClient doctorClient;
	
	public Doctor getDoctorById(Long id) {
		System.out.println("service -------------------->" + id);
		Doctor doctor = doctorClient.getDoctorById(id);
		System.out.println("doctor ***********" + doctor);
		return doctor;
	}

	public List<Doctor> getAllDoctors() {
		return doctorClient.getAllDoctors();
	}

}
