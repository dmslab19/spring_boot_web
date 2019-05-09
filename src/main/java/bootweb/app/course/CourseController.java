package bootweb.app.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bootweb.domain.model.Course;
import bootweb.domain.service.CourseService;

@Controller
@RequestMapping("courses")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET)
	String coursePage(Model model) {
		String previous = "6";
		String next = "1";
		Course course = courseService.findCourse("0");
		model.addAttribute("course", course);
		model.addAttribute("previous", previous);
		model.addAttribute("next", next);
		return "coursePage";
	}
	
	@RequestMapping(value = "{courseId}", method = RequestMethod.GET)
	String coursePage(@PathVariable("courseId")String courseId, Model model) {
		String previous = "";
		String next = "";
		Course course = courseService.findCourse(courseId);
		if (course == null) {
			return "error";
		}
		previous = String.valueOf((Integer.valueOf(course.getCourseId()) + 6) % 7 );
		next = String.valueOf((Integer.valueOf(course.getCourseId()) + 1) % 7 );
		model.addAttribute("course", course);
		model.addAttribute("previous", previous);
		model.addAttribute("next", next);
		return "coursePage";
	}
}
