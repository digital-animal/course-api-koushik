package com.zahid.course;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.zahid.topic.Topic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
public class Course {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String decription;

    @Getter
    @Setter
    @ManyToMany(
        fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }
    )
    @JoinTable(
        name = "topic_course_tb",
        joinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id"),
        },
        inverseJoinColumns = {
            @JoinColumn(name="topic_id", referencedColumnName = "id")
        }
    )
    private Set<Topic> topics = new HashSet<>();
    
    public Course(String name, String decription) {
        this.name = name;
        this.decription = decription;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", decription=" + decription + "]";
    }
    
}
