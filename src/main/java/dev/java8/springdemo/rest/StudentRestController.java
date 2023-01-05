package dev.java8.springdemo.rest;

import dev.java8.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private final Logger logger = Logger.getLogger(StudentRestController.class.getName());

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Erdal", "Güzel"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int studentId) throws StudentNotFoundException {
		if (studentId < 0 || (studentId >= students.size())) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}
		return students.get(studentId);
	}
}
