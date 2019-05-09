package bootweb.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootweb.domain.model.Course;
import bootweb.domain.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	public Course findCourse(String courseId) {
		return courseRepository.findByCourseId(courseId);
	}
	
	public List<Course> findAllCourses() {
		return courseRepository.findAll();
	}
}
