package com.wipro.appointmentbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.appointmentbooking.entity.Patient;
import com.wipro.appointmentbooking.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getPatients() {
		return patientRepository.findAll();
	}

	public Patient getPatient(Long id) {
		return patientRepository.findById(id).orElse(null);
	}

	

	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}

	public Patient updatePatient(Long id, Patient patient) {
		
		Optional<Patient> pat = patientRepository.findById(id);
		if (pat.isPresent()) {
			Patient existingPatient = pat.get();
			existingPatient.setName(patient.getName());
			existingPatient.setAge(patient.getAge());
			existingPatient.setBlood(patient.getBlood());
			existingPatient.setDisease(patient.getDisease());
			return patientRepository.save(existingPatient);

		}else {
			throw new RuntimeException("patient  " + id +" not found");
		}
	}

	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}
}
