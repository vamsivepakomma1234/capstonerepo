package com.wipro.appointmentbooking.dto;

public class Doctor {

	private Long did;

	private String name;

	private String specialization;

	private String contact;

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", name=" + name + ", specialization=" + specialization + ", contact=" + contact
				+ "]";
	}

}
