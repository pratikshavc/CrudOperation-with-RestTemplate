package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentClass;
import com.example.repository.Repository_Student;

@RestController
@RequestMapping("/student")
public class Controller_Student {
	
	@Autowired
	 Repository_Student studRepo ;
	
	@GetMapping("/get")
	public List<StudentClass> getdata()
	{
		List<StudentClass> studList= (List<StudentClass>) studRepo.findAll();
		return studList; 
	}

	@PostMapping("/save")
	public void savedata(@RequestBody StudentClass student)
	{
		studRepo.save(student);
		//return "Record save successfully";
	}
	
	@PutMapping("/update/{id}")
	public void updatedetails(@PathVariable Integer id, @RequestBody StudentClass stud) {
		Optional<StudentClass> student = studRepo.findById(id);
		StudentClass stud1 = student.get();
		stud1.setName(stud.getName());
		stud1.setMarks(stud.getMarks());
		studRepo.save(stud1);
		//return "Record Updated Successfully......";
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteRecord(@PathVariable Integer id){
		studRepo.deleteById(id);
	//return "Record deleted.......";
		
	}
}
