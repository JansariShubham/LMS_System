package com.spring.lms.service;

import com.spring.lms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

//import com.spring.lms.controller.List;
import com.spring.lms.model.Tutor;
import com.spring.lms.repository.TutorRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Service
public class TutorService {

	@Autowired
	private TutorRepo tutorRepo;

	@Value("${uploadDir}")
	private String uploadDir;
	/*public Tutor saveTutor(Tutor tutor) {
		// TODO Auto-generated method stub
		return tutorRepo.save(tutor);
	}

	public List<Tutor> getTutors() {
//		// TODO Auto-generated method stub
		return tutorRepo.findAll();
	}

	public Tutor getTutorById(int tutor_id) {
		// TODO Auto-generated method stub
		return tutorRepo.findById(tutor_id).orElse(null);
	}

	public String deleteTutor(int user_id) {
		// TODO Auto-generated method stub
		tutorRepo.deleteById(user_id);
		return "tutor removed";
	}

	public Tutor updateTutor(Tutor tutor) {
		// TODO Auto-generated method stub

		Tutor existingTutor = tutorRepo.findById(tutor.getTutor_id()).orElse(null);
		existingTutor.setFirstName(tutor.getFirstName());
		existingTutor.setLastName(tutor.getLastName());
		existingTutor.setEmail(tutor.getEmail());
		existingTutor.setPhoneNo(tutor.getPhoneNo());
		existingTutor.setPassword(tutor.getPassword());
		return tutorRepo.save(existingTutor);
	}*/

	/*public Tutor uploadTutorImageWithBasicData(MultipartFile file, HttpServletRequest request, User userObj){
		try{
			String uploadDirectory = request.getServletContext().getRealPath(uploadDir);
			System.out.println("\nUpload directory: " + uploadDirectory);

			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();

			if(fileName == null || fileName.contains("..")){
				System.out.println("\nInvalid file name..\n");
				return null;
			}
			try{
				File dir = new File(uploadDirectory);
				if(! dir.exists()){
					System.out.println("\nFolder Created..\n");
					dir.mkdir();
				}
				BufferedOutputStream bfstream = new BufferedOutputStream(new FileOutputStream( new File(filePath)));
				bfstream.write(file.getBytes());
				bfstream.close();
			}catch(Exception e){
				System.out.println("\nError while saving file locally... " + e.getMessage());
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			Tutor tutorObj = new Tutor();
			tutorObj.setUser(userObj);
			tutorObj.setTutorImage(imageData);

			try{
				System.out.println("\nSaving tutor object...\n");
				return tutorRepo.save(tutorObj);
			}
			catch(Exception e){
				System.out.println("\nError occured: " + e.getMessage());
				e.printStackTrace();
			}
		}catch(Exception e){
			System.out.println("\nError during file upload: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}*/
	
}
