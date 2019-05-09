package bootweb.domain.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import bootweb.domain.model.Course;

@Repository
public class CourseRepository {
	private List<Course> courses;
	
	public CourseRepository() {
		this.courses = new LinkedList<>();
		List<String> name = new LinkedList<>();
		name.add("OpenSourceSoftware1");
		name.add("Distributed Systems");
		name.add("Artificial Intelligence");
		name.add("Distributed Systems");
		name.add("Algorithm");
		name.add("ComputerNetwork");
		name.add("Datastructure");
		for(int i=0; i<name.size(); i ++) {
			Course a = new Course();
			a.setCourseId(String.valueOf(i));
			a.setCourseName(name.get(i));
			this.courses.add(a);
		}
	}
	
	public List<Course> findAll() {
		return this.courses;
	}
	
	public Course findByCourseId(String courseId) {
		Course course = null;
		for (Course temp : this.courses) {
			if (courseId.equals(temp.getCourseId())) {
				course = temp;
			}
		}
		return course;
	}
}
