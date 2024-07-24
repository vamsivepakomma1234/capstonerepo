package com.wipro.appointmentbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.appointmentbooking.dto.Doctor;
import com.wipro.appointmentbooking.entity.Appointment;
import com.wipro.appointmentbooking.service.AppointmentService;
import com.wipro.appointmentbooking.service.DoctorService;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/addapmt")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return appointmentService.createAppointment(appointment);
	}

	@GetMapping("/getapmts")
	public List<Appointment> getAppointments() {
		return appointmentService.getAppointments();
	}

//    @GetMapping("/appointments/{id}")
//    public Appointment getAppointment(@PathVariable Long id) {
//     //   return appointmentService.getAppointment(id);
//    }

	@PutMapping("/updateapmt/{id}")
	public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		return appointmentService.updateAppointment(id, appointment);
	}

	@DeleteMapping("/deleteapmt/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
		return "Appointment deleted successfully";
	}

	@GetMapping("/searchdoctor/{id}")
	public ResponseEntity<Doctor> searchByDoctorId(@PathVariable Long id) {
		System.out.println("id --------------------> " + id);
		Doctor doctor = doctorService.getDoctorById(id);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}

	@GetMapping("/listalldoctors")
	public ResponseEntity<List<Doctor>> listAllDoctors() {
		List<Doctor> doclist = doctorService.getAllDoctors();
		if (doclist.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(doclist, HttpStatus.OK);
	}
}