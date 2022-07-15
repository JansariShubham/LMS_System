package com.spring.lms.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.spring.lms.service.EnrollmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EnrollController {

	@Autowired
	private EnrollmentService enrollmentService;

	@PostMapping("/create-order")
	public String createOrder(@RequestBody Map<String, Object> data) throws Exception {
		return enrollmentService.createOrder(data);

	}

}
