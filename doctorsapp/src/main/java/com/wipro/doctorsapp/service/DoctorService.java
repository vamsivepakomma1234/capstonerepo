package com.wipro.doctorsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.doctorsapp.entity.Doctor;
import com.wipro.doctorsapp.repository.DoctorRepository;

@Service
public class DoctorService<AppointmentRepository> {

	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).orElseThrow();
	}

	public Doctor createDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor updateDoctor(Long id, Doctor doctor) {
		Doctor existingDoctor = doctorRepository.findById(id).orElseThrow();
		existingDoctor.setName(doctor.getName());
		existingDoctor.setSpecialization(doctor.getSpecialization());
		existingDoctor.setContact(doctor.getContact());
		return doctorRepository.save(existingDoctor);
	}

	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}

}
