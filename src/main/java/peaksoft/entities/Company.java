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
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "company_gen")
    @SequenceGenerator(name = "company_gen",sequenceName ="company_seq", allocationSize = 1)

    private Long id;
    @Column(unique = true)
    private String name;
    private  String country;
    private  String address;
    private  String phoneNumber;
    @ManyToMany( cascade = {MERGE,REFRESH,REMOVE,DETACH} ,mappedBy = "companies")
   private  List<Instructor> instructor;
    @OneToMany( cascade = CascadeType.ALL,mappedBy = "companies")
    private List<Course> courses;

    public Company(String name, String country, String address, String phoneNumber, List<Instructor> instructor, List<Course> courses) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instructor = instructor;
        this.courses = courses;
    }
}
