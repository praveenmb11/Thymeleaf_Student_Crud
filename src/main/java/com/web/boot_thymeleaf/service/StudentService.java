package com.web.boot_thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.boot_thymeleaf.model.Student;
import com.web.boot_thymeleaf.stdrepository.StdRepository;

@Service
public class StudentService {

	@Autowired
	StdRepository stdRepository;

	public Student insert(Student student) {
		return stdRepository.save(student);
	}

	public Optional<Student> find_by_id(int sid) {
//		Optional<Student> optional=return stdRepository.findById(sid);
		return stdRepository.findById(sid);
//		return optional;
	}

	public List<Student> fetchall() {
		List<Student> list=stdRepository.findAll();
		return list;
	}
	
	public String remove_by_id(int sid) {
		Optional<Student> optional= stdRepository.findById(sid);
		if(optional.isPresent()) {
		stdRepository.deleteById(sid);
		return "deleted" +sid;
		}
		else {
			return "no data found for" +sid;
		}
	}
	public String removeall() {
		List<Student> list=stdRepository.findAll();
		if(list.isEmpty()) {
			return "No data to delete";
		}
		else {
			stdRepository.deleteAll();
			return "deleted all";
		}
	}
}
