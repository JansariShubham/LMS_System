package com.spring.lms.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.spring.lms.model.Enrollment;
import com.spring.lms.repository.EnrollmentRepo;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepo enrollmentRepo;

	public String createOrder(Map<String, Object> data) throws Exception {
		int amount = Integer.parseInt(data.get("amount").toString());
		System.out.println(amount);

		RazorpayClient client = new RazorpayClient("rzp_test_0OYWVJUOQXo91j", "M0m7pZu7OhumX9UhFwsStgC7");
		JSONObject obj = new JSONObject();
		obj.put("amount", amount * 100);
		obj.put("currency", "INR");

		Order order = client.Orders.create(obj);
//		Enrollment enrollment = new Enrollment();
//
//		enrollment.setOrderId(order.get("id"));
//		enrollment.setStatus(order.get("status"));
//		enrollment.setDate(LocalDateTime.now());

//		enrollmentRepo.save(enrollment);

		System.out.println(order);

		return order.toString();

	}

	public String updateOrder(Map<String, Object> data) {
		// TODO Auto-generated method stub
		Enrollment enrollment = new Enrollment();
//		Enrollment enrollment = enrollmentRepo.findByorderId(data.get("order_id").toString());

		enrollment.setOrderId(data.get("order_id").toString());
//		enrollment.setStatus(data.get("status").toString());
		enrollment.setDate(LocalDateTime.now());
		enrollment.setCourseId((int) data.get("courseId"));
		enrollment.setUserId((int) data.get("userId"));
		
		enrollment.setPaymentId(data.get("payment_id").toString());

		enrollmentRepo.save(enrollment);
		return null;

	}

}
