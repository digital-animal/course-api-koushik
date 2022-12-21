package com.zahid.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(CourseSeeder.class);

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if(courseRepository.count() == 0) {
            Course curse1 = new Course("Git", "Git and Github Crash Course");
            Course curse2 = new Course("Maven", "Maven for Java Developers");
            Course curse3 = new Course("JUnit", "Junit 5 for unit testing");
            Course curse4 = new Course("Spring Boot", "Spring Boot 3 for Java Developers");
            Course curse5 = new Course("Bash", "Bash Programming for Beginners");

            courseRepository.save(curse1);
            courseRepository.save(curse2);
            courseRepository.save(curse3);
            courseRepository.save(curse4);
            courseRepository.save(curse5);
        }

        logger.info("Number of course(s): {}", courseRepository.count());
    }
    
}
