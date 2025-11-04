package com.web.boot_thymeleaf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.boot_thymeleaf.model.Student;
import com.web.boot_thymeleaf.service.StudentService;

@Controller
public class StdController {

	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/ih")
	public String view() {
		return "insert";
	}

	@PostMapping("/insert")
	//@ResponseBody
	public String insert(@ModelAttribute Student student,ModelMap modelMap) {
		studentService.insert(student);
		modelMap.put("message", "Data Inserted");
		return "home";
	}

	@GetMapping("/find")
	@ResponseBody
	public Optional<Student> find_by_id(int sid) {
		return studentService.find_by_id(sid);
	}

	@GetMapping("/fall")
//	@ResponseBody
	public String fetchall(ModelMap modelMap) {
		 modelMap.put("students", studentService.fetchall());
		 return "fetch";
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
