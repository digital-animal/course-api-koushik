package com.zahid.course;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.topic.Topic;
import com.zahid.topic.TopicRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;
    
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public Course getCourse(Integer id) {
        return courseRepository.findById(id).get();
    }


    public Course updateCourse(Course course, Integer id) {
        // Course t = courseRepository.findById(id).get();
        // t = course;
        // return courseRepository.save(t);
        return courseRepository.save(course);
    }


    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }


    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    public Course addTopicToCourse(Integer courseId, Integer topicId) {

        Course course = courseRepository.findById(courseId).get();
        Topic newTopic = topicRepository.findById(topicId).get();

        Set<Topic> topics = course.getTopics();

        topics.add(newTopic);
        course.setTopics(topics);

        return courseRepository.save(course);
    }

    public List<Course> getCoursesByName(String courseName) {
        return courseRepository.findByName(courseName);
    }

}
