package com.spring.lms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.spring.lms.model.Enrollment;
import com.spring.lms.repository.EnrollmentRepo;

@Service
@Transactional
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
		System.out.println(order);

		return order.toString();

	}

	public String updateOrder(Map<String, Object> data) {
		// TODO Auto-generated method stub
		Enrollment enrollment = new Enrollment();
		enrollment.setOrderId(data.get("order_id").toString());
		enrollment.setDate(LocalDateTime.now());
		enrollment.setCourseId((int) data.get("courseId"));
		enrollment.setUserId((int) data.get("userId"));
		enrollment.setPaymentId(data.get("payment_id").toString());

		enrollmentRepo.save(enrollment);
		return null;
	}
	public Optional<List<Integer>> getMyCourses(int id) {
		return enrollmentRepo.getMyCourses(id);
	}
}
