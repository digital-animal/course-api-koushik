package com.zahid.topic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private final Logger logger = LoggerFactory.getLogger(TopicService.class);

    @Autowired
    private TopicRepository topicRepository;
    
    public List<Topic> getAllTopics() {
        List<Topic> topics = null;
        try {
            topics = topicRepository.findAll();
        } catch (Exception e) {
            logger.equals(e.toString());
        }
        // return topicRepository.findAll();
        return topics;
    }

    public Topic getTopic(Integer id) {
        return topicRepository.findById(id).get();
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic, Integer id) {
        // Topic t = topicRepository.findById(id).get();
        // t = topic;
        // return topicRepository.save(t);
        return topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }

    // public Topic enrollTopicToCourse(Integer topicId, Integer courseId) {

    //     Topic topic = topicRepository.findById(topicId).get();
    //     Course course = courseRepository.findById(courseId).get();
    //     Set<Course> courses = topic.getAllCourses();
    //     courses.add(course);
    //     topic.setCourses(courses);

    //     return topicRepository.save(topic);
    // }
    
}
