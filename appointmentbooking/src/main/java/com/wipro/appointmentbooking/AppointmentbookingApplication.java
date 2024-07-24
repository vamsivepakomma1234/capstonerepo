package com.wipro.appointmentbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.wipro.appointmentbooking.service")
public class AppointmentbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentbookingApplication.class, args);
	}

}
