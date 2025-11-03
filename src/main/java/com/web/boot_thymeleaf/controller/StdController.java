package com.web.boot_thymeleaf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.boot_thymeleaf.model.Student;
import com.web.boot_thymeleaf.service.StudentService;

@Controller
public class StdController {

	@Autowired
	StudentService studentService;

	@GetMapping("/ih")
	public String view() {
		return "insert";
	}

	@PostMapping("/insert")
	@ResponseBody
	public Student insert(@ModelAttribute Student student) {
		studentService.insert(student);
		return student;
	}

	@GetMapping("/find")
	@ResponseBody
	public Optional<Student> find_by_id(int sid) {
		return studentService.find_by_id(sid);
	}

	@GetMapping("/fall")
	@ResponseBody
	public List<Student> fetchall() {
		return studentService.fetchall();
	}
	@GetMapping("/did")
	@ResponseBody
	public String remove_by_id(int sid) {
		return studentService.remove_by_id(sid);
	}
	
	@GetMapping("/dall")
	@ResponseBody
	public String removeall() {
		return studentService.removeall();
		
	}
}
