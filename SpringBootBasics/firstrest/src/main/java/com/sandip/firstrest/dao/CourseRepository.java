package com.sandip.firstrest.dao;

import org.springframework.data.repository.CrudRepository;

import com.sandip.firstrest.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	public Course findById(long id);

}
