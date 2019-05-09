package bootweb.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bootweb.domain.model.Course;
import bootweb.domain.service.CourseService;

@Controller
public class FirstpageController {
	@Autowired
	CourseService courseService;
	
	//StudentService studentService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	String firstPage(Model model) {
		List<Course> courses = courseService.findAllCourses();
		model.addAttribute("courses", courses);
		return "firstPage";
	}
}
