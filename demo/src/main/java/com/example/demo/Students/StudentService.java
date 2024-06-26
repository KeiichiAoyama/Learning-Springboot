package com.example.demo.Students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

    public void deleteStudent(Long studentId) {
       boolean exist = studentRepository.existsById(studentId);

	   if(!exist){
		throw new IllegalStateException("student with id " + studentId + " does not exist");
	   }

	   studentRepository.deleteById(studentId);
    }

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Students student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
			student.setName(name);
		}

		if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
			student.setEmail(email);
		}

		
	}
}
