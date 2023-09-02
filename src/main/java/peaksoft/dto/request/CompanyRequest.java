package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Instructor;

import java.util.List;

@Getter
@Setter
public class CompanyRequest {
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    private String  specialization;
    private Group group;
    private List<Instructor> instructor;
    private List<Course> courses;
}
