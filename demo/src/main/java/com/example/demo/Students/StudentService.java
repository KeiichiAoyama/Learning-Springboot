package com.example.demo.Students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentService {
    public List<Students> getStudents(){
		return List.of(
			new Students(1L, "Mariam", 21, LocalDate.of(2000, Month.JANUARY, 5), "mariam.jamal@gmail.com")
		);
	}
}
