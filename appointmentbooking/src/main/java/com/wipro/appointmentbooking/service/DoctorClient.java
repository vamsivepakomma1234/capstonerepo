package com.wipro.appointmentbooking.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.appointmentbooking.dto.Doctor;

@FeignClient(name = "DOCTORSAPP/api/doctors")
public interface DoctorClient {
	@GetMapping("/all")
	List<Doctor> getAllDoctors();
	
	

	@GetMapping("/{id}")
	Doctor getDoctorById(@PathVariable("id") Long id);
}
