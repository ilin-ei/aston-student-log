package aston.studentlog.service;

import java.util.List;

import aston.studentlog.model.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);
	
}
