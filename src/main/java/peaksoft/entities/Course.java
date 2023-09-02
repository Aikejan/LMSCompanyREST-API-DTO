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
@Table(name = "cources")
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
    @ManyToOne
    private  Company companies;
    @ManyToMany(mappedBy = "courses")
    private List<Group> groups;
    @ManyToOne
    private Instructor instructors;

    public Course(String name, ZonedDateTime dataOfStart, String description, Company companies, List<Group> groups, Instructor instructors) {
        this.name = name;
        this.dataOfStart = dataOfStart;
        this.description = description;
        this.companies = companies;
        this.groups = groups;
        this.instructors = instructors;
    }
}
