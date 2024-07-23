package com.wipro.appointmentbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.appointmentbooking.entity.Patient;
import com.wipro.appointmentbooking.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/addpatient")
    public com.wipro.appointmentbooking.entity.Patient createPatient(@RequestBody Patient patient) {
    	System.out.println("-----" +patient);
        return patientService.createPatient(patient);
    }

    @GetMapping("/allpatient")
    public List<com.wipro.appointmentbooking.entity.Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/getpatbyid/{id}")
    public com.wipro.appointmentbooking.entity.Patient getPatient(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @PutMapping("/updatepatient/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully";
    }
}