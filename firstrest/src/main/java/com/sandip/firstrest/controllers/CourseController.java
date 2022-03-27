package com.sandip.firstrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandip.firstrest.dao.CourseRepository;
import com.sandip.firstrest.entities.Course;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("")
	public List<Course> getAllCourses() {
		return (List<Course>) courseRepository.findAll();
	}

	@GetMapping("/{courseId}")
	public Course getOneCourse(@PathVariable("courseId") long courseId) {
		return courseRepository.findById(courseId);
	}

	@PostMapping("")
	public void createNewCourse(@RequestBody Course course) {
		courseRepository.save(course);
	}

	@PutMapping("")
	public void updateOldCourse(@RequestBody Course course) {
		courseRepository.save(course);
	}

	@DeleteMapping("/{courseId}")
	public void deleteCourse(@PathVariable(name = "courseId") long courseId) {
		courseRepository.deleteById(courseId);

	}

}
