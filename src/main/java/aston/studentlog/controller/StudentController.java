package aston.studentlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aston.studentlog.model.Student;
import aston.studentlog.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents(){		
		return studentService.getStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		Student theStudent = studentService.getStudent(studentId);		
		return theStudent;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent) {
		
		theStudent.setId(0);
		studentService.saveStudent(theStudent);				
		return theStudent;
	}
	
	@DeleteMapping("/students/{customerId}")
	public String deleteStudent(@PathVariable int studentId){

		studentService.deleteStudent(studentId);
		return "Deleted student " + studentId;
	}
}
