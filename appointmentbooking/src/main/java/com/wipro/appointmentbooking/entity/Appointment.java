
package com.wipro.appointmentbooking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate apmtDate;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime apmtTime;
	@Column
	private String doctorName;

	@OneToOne
	@JoinColumn(name = "pid")
	private Patient patient;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public LocalDate getApmtDate() {
		return apmtDate;
	}

	public void setApmtDate(LocalDate apmtDate) {
		this.apmtDate = apmtDate;
	}

	

	public LocalTime getApmtTime() {
		return apmtTime;
	}

	public void setApmtTime(LocalTime apmtTime) {
		this.apmtTime = apmtTime;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", apmtDate=" + apmtDate + ", apmtTime=" + apmtTime + ", doctorName="
				+ doctorName + ", patient=" + patient + "]";
	}

	
	public void setAge(Object age) {
		// TODO Auto-generated method stub
		
	}

	public void setBlood(Object blood) {
		// TODO Auto-generated method stub
		
	}

	public void setDisease(Object disease) {
		// TODO Auto-generated method stub
		
	}

}