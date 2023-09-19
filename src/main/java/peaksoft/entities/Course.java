package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_gen")
    @SequenceGenerator(name = "course_gen",sequenceName ="course_seq", allocationSize = 1)
    private Long id;
    private String name;
    private ZonedDateTime dataOfStart;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    private  Company company;
    @ManyToMany(mappedBy = "courses",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    private List<Group> groups;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private Instructor instructors;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
    private List<Lesson> lessons;

    public Course(String name, ZonedDateTime dataOfStart, String description, Company company, List<Group> groups, Instructor instructors) {
        this.name = name;
        this.dataOfStart = dataOfStart;
        this.description = description;
        this.company = company;
        this.groups = groups;
        this.instructors = instructors;
    }
}
