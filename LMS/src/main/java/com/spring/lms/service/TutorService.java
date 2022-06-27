package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//import com.spring.lms.controller.List;
import com.spring.lms.model.Tutor;
import com.spring.lms.repository.TutorRepo;

@Service
public class TutorService {

	@Autowired
	TutorRepo tutorRepo;

//	public Tutor saveTutor(Tutor tutor) {
//		// TODO Auto-generated method stub
//		return tutorRepo.save(tutor);
//	}
//
//	public List<Tutor> getTutors() {
////		// TODO Auto-generated method stub
//		return tutorRepo.findAll();
//	}

	public Tutor getTutorById(int tutor_id) {
		// TODO Auto-generated method stub
		return tutorRepo.findById(tutor_id).orElse(null);
	}

	public String deleteTutor(int user_id) {
		// TODO Auto-generated method stub
		tutorRepo.deleteById(user_id);
		return "tutor removed";
	}

//	public Tutor updateTutor(Tutor tutor) {
//		// TODO Auto-generated method stub
//		
//		Tutor existingTutor = tutorRepo.findById(tutor.getTutor_id()).orElse(null);
//		existingTutor.setFirstName(tutor.getFirstName());
//		existingTutor.setLastName(tutor.getLastName());
//		existingTutor.setEmail(tutor.getEmail());
//		existingTutor.setPhoneNo(tutor.getPhoneNo());
//		existingTutor.setPassword(tutor.getPassword());
//		return tutorRepo.save(existingTutor);
//	}

//	public String deleteTutor(int tutor_id) {
//		// TODO Auto-generated method stub
//		tutorRepo.deleteById(tutor_id);
//		return "Tutor Removed!! " + tutor_id;
//	}
	
}
