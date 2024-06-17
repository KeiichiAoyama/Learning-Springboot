package com.example.demo.Students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}

    public List<Students> getStudents(){
		return studentRepository.findAll();
	}

    public void addNewStudent(Students student) {
		Optional<Students> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()){
			throw new IllegalStateException("email taken");
		}

        studentRepository.save(student);
    }
}
