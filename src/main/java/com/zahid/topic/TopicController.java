package com.zahid.topic;

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
@RequestMapping("/topics")
public class TopicController {

    private final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @GetMapping("/all")
    public List<Topic> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        logger.info("All Topics: {}", topics);
        return topics;
    }

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable("id") Integer id) {
        Topic topic = topicService.getTopic(id);
        logger.info("Topic: {}", topic);
        return topic;
    }

    @PostMapping
    public ResponseEntity<String> addTopic(@RequestBody Topic topic) {
        logger.info("New Topic = {}", topic);

        topicService.addTopic(topic);

        return ResponseEntity.ok("Topic Added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTopic(@RequestBody Topic topic, @PathVariable("id") Integer id) {
        logger.info("Updated Topic = {}", topic);
        topicService.updateTopic(topic, id);
        return ResponseEntity.ok("Topic Updated");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable("id") Integer id) {
        logger.info("Topic Id = {}", id);
        topicService.deleteTopic(id);

        return ResponseEntity.ok("Topic Deleted");
    }

}

