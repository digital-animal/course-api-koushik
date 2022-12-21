package com.zahid.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TopicSeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(TopicSeeder.class);

    @Autowired
    TopicRepository topicRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if(topicRepository.count() == 0) {
            Topic topic1 = new Topic("Git", "Git and Github Crash Course");
            Topic topic2 = new Topic("Maven", "Maven for Java Developers");
            Topic topic3 = new Topic("JUnit", "Junit 5 for unit testing");
            Topic topic4 = new Topic("Spring Boot", "Spring Boot 3 for Java Developers");
            Topic topic5 = new Topic("Bash", "Bash Programming for Beginners");

            topicRepository.save(topic1);
            topicRepository.save(topic2);
            topicRepository.save(topic3);
            topicRepository.save(topic4);
            topicRepository.save(topic5);
        }

        logger.info("Number of topic(s): {}", topicRepository.count());
    }
    
}
