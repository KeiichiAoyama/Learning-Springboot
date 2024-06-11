package com.example.demo.Students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @GetMapping
	public List<Students> getStudents(){
		return List.of(
			new Students(1L, "Mariam", 21, LocalDate.of(2000, Month.JANUARY, 5), "mariam.jamal@gmail.com")
		);
	}
}
