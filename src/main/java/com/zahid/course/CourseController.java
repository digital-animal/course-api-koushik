package com.zahid.course;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        logger.info("All Courses: {}", courses);
        return courses;
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Integer id) {
        Course course = courseService.getCourse(id);
        logger.info("Course: {}", course);
        return course;
    }

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        logger.info("New Course = {}", course);

        courseService.addCourse(course);

        return ResponseEntity.ok("Course Added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@RequestBody Course course, @PathVariable("id") Integer id) {
        logger.info("Updated Course = {}", course);
        courseService.updateCourse(course, id);
        return ResponseEntity.ok("Course Updated");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Integer id) {
        logger.info("Course Id = {}", id);
        courseService.deleteCourse(id);

        return ResponseEntity.ok("Course Deleted");
    }

    @PutMapping("/{courseId}/{topicId}")
    public Course addTopicToCourse(
            @PathVariable("courseId") Integer courseId,
            @PathVariable("topicId") Integer topicId
    ) {
        return courseService.addTopicToCourse(courseId, topicId);
    }

    @GetMapping("/name/{courseName}")
    public List<Course> getCoursesByName(@PathVariable("courseName") String courseName) {
        System.out.println(courseName);
        List<Course> courses = courseService.getCoursesByName(courseName);
        logger.info("All Courses: {}", courses);
        return courses;
    }
}

