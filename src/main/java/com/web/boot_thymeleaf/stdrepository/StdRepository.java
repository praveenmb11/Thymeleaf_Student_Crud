package com.web.boot_thymeleaf.stdrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.boot_thymeleaf.model.Student;

public interface StdRepository extends JpaRepository<Student, Integer> {

}
