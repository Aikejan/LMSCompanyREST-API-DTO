package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "instructors")
@NoArgsConstructor
@AllArgsConstructor

public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen",sequenceName ="instructor_seq", allocationSize = 1)

    private  Long id;
    private  String firstName;
    private  String lastName;
    private  String phoneNumber;
    private String specialization;

    @ManyToMany(cascade = {PERSIST,DETACH,REFRESH,MERGE})
    private List<Company> companies;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "instructors")
    private List<Course> courses;

    @OneToOne(cascade = ALL)
    private User user;

    public Instructor(String firstName, String lastName, String phoneNumber, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }
}
